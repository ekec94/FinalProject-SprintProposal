package com.example.finalproject

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.adapter.IngredientListAdapter
import com.example.finalproject.models.IngredientListModel


class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        // define app bar - toolbar
        setSupportActionBar(findViewById(R.id.idToolbar))

        // display title of activity page
        supportActionBar!!.title = "Filter the Recipes"
        // allow the user to return to main activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
}
