package com.wizyta.aplikacja.views.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wizyta.aplikacja.R
import com.wizyta.aplikacja.recyclerViews.AppointmentRecyclerViewAdapter
import com.wizyta.aplikacja.helpers.AppointmentRequest
import com.wizyta.aplikacja.helpers.AppointmentResponse
import com.wizyta.aplikacja.backend.ServerApi
import com.wizyta.aplikacja.backend.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.Calendar


class AppointmentFragment : Fragment() {

    private companion object {
        private const val DoctorNameKey = "doctor_name"
        private const val DoctorIdKey = "doctor_id"
        private lateinit var pickedDate: LocalDateTime;
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_appointment, container, false)
        onCreateRecyclerView(root)
        onCreateTextInput(root)
        onCreateButton(root)
        onCreateButtonDate(root)
        return root
    }

    private fun onCreateButtonDate(root: View) {
        val pickDateTimeButton = root.findViewById<Button>(R.id.pickDateTimeButton)
        val textAddDate = root.findViewById<TextView>(R.id.textAddDate)
        pickDateTimeButton.setOnClickListener {


            // date: Calendar? = null
            val currentDate: Calendar = Calendar.getInstance()
            var date = Calendar.getInstance()
            DatePickerDialog(
                context!!,
                { view, year, monthOfYear, dayOfMonth ->
                    date?.set(year, monthOfYear, dayOfMonth)
                    TimePickerDialog(context,
                        { view, hourOfDay, minute ->
                            date?.set(Calendar.HOUR_OF_DAY, hourOfDay)
                            date?.set(Calendar.MINUTE, minute)
                            Log.v("DATE", "The choosen one " + date?.getTime())
                            Log.v("DATE", "The choosen one " + date.timeInMillis)

                            pickedDate = LocalDateTime.ofEpochSecond(date.timeInMillis/1000,0,
                                ZoneOffset.ofTotalSeconds(0))
                            //textAddDate.setText(date.time.toString())
                            //textAddDate.setText(date.time.toString())
                            textAddDate.setText(pickedDate.toString())

                        },
                        currentDate.get(Calendar.HOUR_OF_DAY),
                        currentDate.get(Calendar.MINUTE),
                        true
                    ).show()
                },
                currentDate.get(Calendar.YEAR),
                currentDate.get(Calendar.MONTH),
                currentDate.get(Calendar.DATE)
            ).show()

        }
    }


    private fun onCreateRecyclerView(root: View) {
        val serverApi = Retrofit.client?.create(ServerApi::class.java)
        val call = serverApi?.getAppointment()
        call?.enqueue(object : Callback<List<AppointmentResponse>>{
            override fun onResponse(call: Call<List<AppointmentResponse>>?, response: Response<List<AppointmentResponse>>?) {
                val doctor = arguments?.getString(DoctorNameKey)
                val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerViewAppointment)
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                val adapter = AppointmentRecyclerViewAdapter(requireContext(),response?.body()?.filter { it.doctor == doctor } ?: ArrayList())
                recyclerView.adapter = adapter
                response?.body()?.forEach { println(it.doctor); println(doctor) }
            }

            override fun onFailure(call: Call<List<AppointmentResponse>>?, t: Throwable?) {
                Toast.makeText(context, "Error occured", Toast.LENGTH_LONG).show()
            }
        })
    }

    var date: Calendar? = null
    fun showDateTimePicker() {
        val currentDate: Calendar = Calendar.getInstance()
        date = Calendar.getInstance()
        DatePickerDialog(
            context!!,
            { view, year, monthOfYear, dayOfMonth ->
                date?.set(year, monthOfYear, dayOfMonth)
                TimePickerDialog(context,
                    { view, hourOfDay, minute ->
                        date?.set(Calendar.HOUR_OF_DAY, hourOfDay)
                        date?.set(Calendar.MINUTE, minute)
                        Log.v("DATE", "The choosen one " + date?.getTime())
                    },
                    currentDate.get(Calendar.HOUR_OF_DAY),
                    currentDate.get(Calendar.MINUTE),
                    true
                ).show()
            },
            currentDate.get(Calendar.YEAR),
            currentDate.get(Calendar.MONTH),
            currentDate.get(Calendar.DATE)
        ).show()
    }

    private fun onCreateTextInput(root: View){



    }

    private fun onCreateButton(root: View){
        val addButton = root.findViewById<Button>(R.id.addButton)
        val addTextInput = root.findViewById<EditText>(R.id.editTextAddName)
        val textAddDate = root.findViewById<TextView>(R.id.textAddDate)
        addButton.setOnClickListener {

            if(addTextInput.text.toString().equals("")){Toast.makeText(context, "You must enter valid name!", Toast.LENGTH_SHORT).show();return@setOnClickListener;}
            if(textAddDate.text.toString().equals("Data")){Toast.makeText(context, "You must enter valid date!", Toast.LENGTH_SHORT).show();return@setOnClickListener;}
            val serverApi = Retrofit.client?.create(ServerApi::class.java)
            val doctorId = arguments?.getInt(DoctorIdKey)
            val call = serverApi?.postAppointment(AppointmentRequest(addTextInput.text.toString(),
                pickedDate.toString(),doctorId));
            call?.enqueue(object : Callback<List<AppointmentResponse>>{
                override fun onResponse(call: Call<List<AppointmentResponse>>?, response: Response<List<AppointmentResponse>>?) {
                    onCreateRecyclerView(root);
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<List<AppointmentResponse>>?, t: Throwable?) {
                    Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show()
                }
            })

        }


    }
}