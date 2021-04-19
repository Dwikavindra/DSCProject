package com.example.dscproject.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.dscproject.R
import com.example.dscproject.fragments.HistoryRecycleryView
import com.example.dscproject.fragments.SessionRecyclerView
import com.example.dscproject.testing

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val fragment=supportFragmentManager.beginTransaction()
        fragment.add(R.id.HistoryRecylerView, HistoryRecycleryView()).commit()
        val daftar:Button = findViewById(R.id.daftar)
        daftar.setOnClickListener(){
            startActivity(Intent(this@Home, testing::class.java))
        }
    }
}