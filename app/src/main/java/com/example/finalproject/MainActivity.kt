package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.models.RecipeListModel
import com.example.custlistviewproject.RecipeListAdapter


// allows all functions to access the recipe list
val recipeList = ArrayList<RecipeListModel>()


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // define app bar - toolbar
        setSupportActionBar(findViewById(R.id.idToolbar))

        // define list view
        val recipeView = findViewById<ListView>(R.id.idRecipeList)

        val dillDumpling = Recipes.DillDumpling()

        val recipeName: String = dillDumpling.name()
        val recipeTime: String = dillDumpling.prepTime()
        val recipeImg: Int = dillDumpling.img()

        // add items to list
        // currently testing -- everytime the back button is used it adds the item again
        recipeList.clear() // current fix -- subject to change?
        recipeList.add(RecipeListModel(recipeName, recipeTime, recipeImg))

        // define list layout
        recipeView.adapter = RecipeListAdapter(
            this, R.layout.recipe_list_item,recipeList
        )

        // to remove warnings changed parameters that are not used to an underscore
        recipeView.setOnItemClickListener { _, _, i, _ ->
            showServingSizeDialog()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // may not use once I figure out how I want the user to access activity 2 and 3
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }

    // actions when an item from the menu is selected
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.idActivity2 -> {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
            true
        }

        R.id.idActivity3 -> {
            val intent = Intent(this, Activity3::class.java)
            startActivity(intent)
            true
        }

        R.id.idActivity4 -> {
            val intent = Intent(this, Activity4::class.java)
            startActivity(intent)
            true
        }

        // from developer.android.com
        else -> {
            // The user's action isn't recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    private fun showServingSizeDialog(){
        // variables for dialog box
        // created to get the serving size from the user
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.serving_size_input, null)
        val numberPicker = dialogLayout.findViewById<NumberPicker>(R.id.idNumberPicker)

        // define number picker properties
        numberPicker.setMaxValue(12) // who's making more than 12 servings of soup?
        numberPicker.setMinValue(2) // recipes by default are one serving
        numberPicker.setWrapSelectorWheel(true)



        // create the dialog box with a number picker
        with(dialogBuilder){
            setTitle("How many servings would you like to make?")
            setPositiveButton("OK"){dialog, which ->
                val servingSize = numberPicker.value // does nothing for now - but this is the variable for the user selected number
                Toast.makeText(context,"The serving size selected: $servingSize", Toast.LENGTH_LONG).show()
            }
            setNeutralButton("Just 1 Serving"){dialog, which ->
                val servingSize = 1
                Toast.makeText(context,"The serving size selected: $servingSize", Toast.LENGTH_LONG).show()
            }
            setNegativeButton("Go Back to Recipes"){dialog, which ->
                Log.d("Main", "Negative button clicked")
            }
            setView(dialogLayout)
            show()
        }
    }
}