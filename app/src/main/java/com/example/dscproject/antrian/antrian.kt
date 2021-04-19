package com.example.dscproject.antrian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.dscproject.R

class antrian : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.antrian)
        val mulai: Button =findViewById(R.id.mulaibutton)
        val backbutton: ImageButton =findViewById(R.id.backbutton)
        mulai.setOnClickListener(){
            startActivity(
                Intent(this@antrian,antrian2::class.java)
            )
            finish()
        }
        backbutton.setOnClickListener(){
            onBackPressed()
        }
    }
}