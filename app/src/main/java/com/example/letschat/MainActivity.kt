package com.example.letschat

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private lateinit var explore:Button

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        explore=findViewById(R.id.explore)
        explore.setOnClickListener()
        {
            val Intent=Intent(this, LoginActivity::class.java)
            startActivity(Intent)
        }

    }
}