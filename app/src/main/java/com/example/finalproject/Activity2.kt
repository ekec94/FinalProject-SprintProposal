package com.example.finalproject

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.adapter.IngredientListAdapter
import com.example.finalproject.models.IngredientListModel


class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        // define app bar - toolbar
        setSupportActionBar(findViewById(R.id.idToolbar))

        // display title of activity page
        supportActionBar!!.title = "Ingredients"
        // allow the user to return to main activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val ingredientView = findViewById<ListView>(R.id.idIngredientList)
        val ingredientList = ArrayList<IngredientListModel>()

        // current state for testing
        // will need to restructure since there will be more than one ingredient to add
        ingredientList.add(IngredientListModel("Testing Ingredient"))
        ingredientView.adapter = IngredientListAdapter(
            this, R.layout.ingredient_list_item,ingredientList
        )
    }
}