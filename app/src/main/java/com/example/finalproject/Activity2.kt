package com.example.finalproject

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.adapter.ShoppingListAdapter
import com.example.finalproject.models.IngredientListModel


class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        // define app bar - toolbar
        setSupportActionBar(findViewById(R.id.idToolbar))

        // display title of activity page
        supportActionBar!!.title = "Shopping List"
        // allow the user to return to main activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val ingredients: List<String> = Recipes.DillDumpling().ingredients()
        val amounts: List<Double> = Recipes.DillDumpling().ingredientAmounts()

        val ingredientView = findViewById<ListView>(R.id.idIngredientList)
        val ingredientList = ArrayList<IngredientListModel>()

        for(i in ingredients.indices) {
            val combinedIngredient = "${amounts[i]} ${ingredients[i]}"
            ingredientList.add(IngredientListModel(combinedIngredient))
        }

        ingredientView.adapter = ShoppingListAdapter(
            this, R.layout.shopping_list_item,ingredientList
        )
    }
}