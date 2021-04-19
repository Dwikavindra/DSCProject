package com.example.dscproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.dscproject.Constants.Constant
import com.example.dscproject.fragments.SessionRecyclerView
import java.text.DateFormat
import java.util.*

class testing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)
        val sharedPreferences=
            getSharedPreferences(Constant.GALENUS_PREFERENCES, Context.MODE_PRIVATE)
        val username=sharedPreferences.getString(Constant.SIGNED_IN_USERNAME,"")!!
        val calendar= Calendar.getInstance()
        val currentDate= DateFormat.getDateInstance().format(calendar.getTime())
        val date: TextView =findViewById(R.id.todaysdate)
        date.setText(currentDate)
        val fragment=supportFragmentManager.beginTransaction()
        fragment.add(R.id.SessionRecyclerView2, SessionRecyclerView()).commit()
    }
}