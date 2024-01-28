package com.wizyta.aplikacja.recyclerViews

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.wizyta.aplikacja.R
import com.wizyta.aplikacja.helpers.AppointmentResponse
import com.wizyta.aplikacja.views.fragments.AppointmentFragment
import java.time.LocalDateTime
import java.time.ZoneOffset


class AppointmentRecyclerViewAdapter internal constructor(private val context: Context, private val  data: List<AppointmentResponse>) : RecyclerView.Adapter<AppointmentRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(context).inflate(R.layout.item_appointment, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textDoctor: TextView = itemView.findViewById(R.id.textDoctor)
        var textAppointment: TextView = itemView.findViewById(R.id.textAppointment)
        var textDate: TextView = itemView.findViewById(R.id.textDate)
        var itemAppointment: LinearLayout = itemView.findViewById(R.id.itemAppointment)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.textDoctor.text = item.doctor
        holder.textAppointment.text = item.name
        holder.textDate.text = item.date
        holder.itemAppointment.setOnClickListener{
            Toast.makeText(context,"Wizyta: ${item.name}, ${item.date}", Toast.LENGTH_SHORT).show()
            val pickedDate = LocalDateTime.parse(item.date)
            println(pickedDate.toString())
            println(pickedDate.toEpochSecond(ZoneOffset.ofTotalSeconds(0)))
            val intent = Intent(Intent.ACTION_INSERT)
            intent.setData(CalendarContract.Events.CONTENT_URI)
            intent.putExtra(CalendarContract.Events.TITLE,item.name)
            intent.putExtra(CalendarContract.Events.DESCRIPTION,"Do wykonania przez "+item.doctor)
            intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,(pickedDate.toEpochSecond(ZoneOffset.ofTotalSeconds(0))*1000))
            intent.putExtra(CalendarContract.Events.ALL_DAY,true)
//            intent.putExtra(Intent.EXTRA_EMAIL,"")
            val pm: PackageManager = this.context.packageManager
            if(intent.resolveActivity(this.context.packageManager) != null){
                this.context.startActivity(intent)
                //finish()
            }else{
                Toast.makeText(this.context, "There is no app that support this action", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


}