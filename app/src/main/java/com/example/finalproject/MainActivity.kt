package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.custlistviewproject.RecipeListModel
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

        // add items to list
        // currently testing -- everytime the back button is used it adds the item again
        recipeList.clear() // current fix -- subject to change?
        recipeList.add(RecipeListModel("Test Name", "1h 45m", R.drawable.ic_launcher_background))



        // define list layout
        recipeView.adapter = RecipeListAdapter(
            this, R.layout.recipe_list_item,recipeList
        )
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

        // from developer.android.com
        else -> {
            // The user's action isn't recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}