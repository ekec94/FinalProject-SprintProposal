package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.adapter.ShoppingListAdapter
import com.example.finalproject.models.IngredientListModel


class Activity2 : AppCompatActivity() {

    private var ingredients: ArrayList<String> = ArrayList()
    private var ingredientAmounts: ArrayList<String> = ArrayList()
    private var instructions: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        // define app bar - toolbar
        setSupportActionBar(findViewById(R.id.idToolbar))

        // display title of activity page
        supportActionBar!!.title = "Shopping List"
        // allow the user to return to main activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        // extras from previous activity
        val extras = intent.extras
        if (extras != null) {
            ingredients = extras.getStringArrayList("Ingredients")!!
            ingredientAmounts = extras.getStringArrayList("IngredientAmounts")!!
            instructions = extras.getStringArrayList("Instructions")!!
        }


        //val ingredients: List<String> = Recipes.DillDumpling().ingredients()
        //val amounts: List<Double> = Recipes.DillDumpling().ingredientAmounts(servingSize)

        val ingredientView = findViewById<ListView>(R.id.idIngredientList)
        val ingredientList = ArrayList<IngredientListModel>()

        for(i in ingredients.indices) {
            val combinedIngredient = "${ingredientAmounts[i]} ${ingredients[i]}"
            ingredientList.add(IngredientListModel(combinedIngredient))
        }

        ingredientView.adapter = ShoppingListAdapter(
            this, R.layout.shopping_list_item,ingredientList
        )

        val nxtBtn: Button = findViewById(R.id.idNxtBtn)

        nxtBtn.setOnClickListener {
            val intent = Intent(this@Activity2, Activity3::class.java)
            intent.putStringArrayListExtra("Ingredients", ingredients)
            intent.putStringArrayListExtra("IngredientAmounts", ingredientAmounts)
            intent.putStringArrayListExtra("Instructions", instructions)

            startActivity(intent)
        }
    }
}