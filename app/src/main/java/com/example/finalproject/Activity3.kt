package com.example.finalproject

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.adapter.IngredientListAdapter
import com.example.finalproject.models.IngredientListModel

class Activity3 : AppCompatActivity() {

    private var ingredients: ArrayList<String> = ArrayList()
    private var ingredientAmounts: ArrayList<String> = ArrayList()
    private var instructions: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        // define app bar - toolbar
        setSupportActionBar(findViewById(R.id.idToolbar))

        // display title of activity page
        supportActionBar!!.title = "How to Prepare"
        // allow the user to return to main activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        // extras from previous activity
        val extras = intent.extras
        if (extras != null) {
            ingredients = extras.getStringArrayList("Ingredients")!!
            ingredientAmounts = extras.getStringArrayList("IngredientAmounts")!!
            instructions = extras.getStringArrayList("Instructions")!!
        }

        val ingredientView = findViewById<ListView>(R.id.idIngredientLV)
        val ingredientList = ArrayList<IngredientListModel>()

        // combine the corresponding amount with the ingredients
        for (i in ingredients.indices) {
            val combinedIngredient = "${ingredientAmounts[i]} ${ingredients[i]}"
            ingredientList.add(IngredientListModel(combinedIngredient))
        }

        // display ingredients in list view
        ingredientView.adapter = IngredientListAdapter(
            this, R.layout.ingredient_list_item, ingredientList
        )

        // variables for how to prepare the soup
        // used the same model and adapter for the ingredient list
        val instructionList = ArrayList<IngredientListModel>()
        val instructionView = findViewById<ListView>(R.id.idInstructionsLV)

        // iterate through the steps of the recipe to display
        for (step in instructions.indices){
            instructionList.add(IngredientListModel(instructions[step]))
        }

        // display steps in list view
        instructionView.adapter = IngredientListAdapter(
            this, R.layout.ingredient_list_item, instructionList
        )
    }
}