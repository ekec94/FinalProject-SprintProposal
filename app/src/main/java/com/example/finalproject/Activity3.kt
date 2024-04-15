package com.example.finalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        // define app bar - toolbar
        setSupportActionBar(findViewById(R.id.idToolbar))

        // display title of activity page
        supportActionBar!!.title = "How to Prepare"
        // allow the user to return to main activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}