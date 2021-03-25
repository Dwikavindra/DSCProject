package com.example.dscproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dscproject.Constants.Constant
import com.example.dscproject.fragments.SessionRecyclerView

class testing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)
        val sharedPreferences=
            getSharedPreferences(Constant.GALENUS_PREFERENCES, Context.MODE_PRIVATE)
        val username=sharedPreferences.getString(Constant.SIGNED_IN_USERNAME,"")!!
        val fragment=supportFragmentManager.beginTransaction()
        fragment.add(R.id.SessionRecyclerView2, SessionRecyclerView()).commit()
    }
}