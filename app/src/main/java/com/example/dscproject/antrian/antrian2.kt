package com.example.dscproject.antrian

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dscproject.Home.Home
import com.example.dscproject.R
import com.example.dscproject.testing
import java.util.*


class antrian2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_antrian2)
        var randomnumber:Int= Random().nextInt(15)
        val nomorantrian: TextView =findViewById(R.id.nomorantrian)
        nomorantrian.setText(randomnumber.toString())
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@antrian2,Home::class.java)
                startActivity(intent)
                finish()
            }
        }, 5000)

    }
}