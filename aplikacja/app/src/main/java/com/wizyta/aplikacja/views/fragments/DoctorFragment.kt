package com.wizyta.aplikacja.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.wizyta.aplikacja.R
import com.wizyta.aplikacja.helpers.DoctorResponse
import com.wizyta.aplikacja.backend.ServerApi
import com.wizyta.aplikacja.backend.Retrofit
import kotlinx.android.synthetic.main.fragment_doctor.*
import kotlinx.android.synthetic.main.fragment_doctor.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DoctorFragment : Fragment() {

    val doctorList = ArrayList<DoctorResponse>()

    private companion object {
        private const val DoctorNameKey = "doctor_name"
        private const val DoctorIdKey = "doctor_id"
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_doctor, container, false)
        fillSpinner(root)
        prepareClickListeners(root)
        return root
    }

    private fun fillSpinner(root: View) {
        val serverApi = Retrofit.client?.create(ServerApi::class.java)
        val call = serverApi?.getDoctors()
        call?.enqueue(object : Callback<List<DoctorResponse>> {
            override fun onResponse(call: Call<List<DoctorResponse>>, response: Response<List<DoctorResponse>>) {
                view?.progressBar?.visibility = View.GONE
                if (doctorList.isEmpty()) {
                    doctorList.addAll(response.body())
                }
                val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, doctorList.map { it.name }.toList())
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                root.doctorSpinner.adapter = adapter
            }

            override fun onFailure(call: Call<List<DoctorResponse>>, t: Throwable?) {
                view?.progressBar?.visibility = View.GONE
                Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun prepareClickListeners(root: View) {
        root.txtNext.setOnClickListener {
            if (doctorList.isNotEmpty()) {
                val bundle = Bundle()
                bundle.putString(DoctorNameKey, doctorList[doctorSpinner.selectedItemPosition].name)
                bundle.putInt(DoctorIdKey, doctorList[doctorSpinner.selectedItemPosition].id)
                println("doctorList[doctorSpinner.selectedItemPosition].name")
                println(doctorList[doctorSpinner.selectedItemPosition].name)
                println("doctorList[doctorSpinner.selectedItemPosition].id")
                println(doctorList[doctorSpinner.selectedItemPosition].id)
                findNavController().navigate(R.id.actionToAppointments, bundle)
            } else {
                Toast.makeText(context, getString(R.string.error_occurred), Toast.LENGTH_SHORT).show()
            }
        }
    }
}