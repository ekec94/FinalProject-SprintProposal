package com.example.finalproject

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.models.RecipeListModel
import com.example.custlistviewproject.RecipeListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


// allows all functions to access the recipe list and recipes
val recipeList = ArrayList<RecipeListModel>()
val filterList: ArrayList<RecipeListModel> = ArrayList()

val dillDumpling = Recipes.DillDumpling()
val frenchOnion = Recipes.FrenchOnion()
val chickenNoodle = Recipes.ChickenNoodle()
val dublinCoddle = Recipes.DublinCoddle()

class MainActivity : AppCompatActivity() {

    private var protein: String? = null
    private var carb: String? = null
    private var time: Int? = null
    private var lowCalorie = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // define app bar - toolbar
        setSupportActionBar(findViewById(R.id.idToolbar))

        // define list view
        val recipeView = findViewById<ListView>(R.id.idRecipeList)

        // add items to list
        // everytime the back button was used it added the item again
        recipeList.clear() // current fix -- subject to change?
        recipeList.add(
            RecipeListModel(
                dillDumpling.name(),
                dillDumpling.cookTime(),
                dillDumpling.img(),
                dillDumpling.ingredients(),
                dillDumpling.ingredientAmounts(),
                dillDumpling.instructions(),
                dillDumpling.resource(),
                dillDumpling.filterTags()
            )
        )
        recipeList.add(
            RecipeListModel(
                frenchOnion.name(),
                frenchOnion.cookTime(),
                frenchOnion.img(),
                frenchOnion.ingredients(),
                frenchOnion.ingredientAmounts(),
                frenchOnion.instructions(),
                frenchOnion.resource(),
                frenchOnion.filterTags()
            )
        )
        recipeList.add(
            RecipeListModel(
                chickenNoodle.name(),
                chickenNoodle.cookTime(),
                chickenNoodle.img(),
                chickenNoodle.ingredients(),
                chickenNoodle.ingredientAmounts(),
                chickenNoodle.instructions(),
                chickenNoodle.resource(),
                chickenNoodle.filterTags()
            )
        )
        recipeList.add(
            RecipeListModel(
                dublinCoddle.name(),
                dublinCoddle.cookTime(),
                dublinCoddle.img(),
                dublinCoddle.ingredients(),
                dublinCoddle.ingredientAmounts(),
                dublinCoddle.instructions(),
                dublinCoddle.resource(),
                dublinCoddle.filterTags()
            )
        )
        val extras = intent.extras
        if (extras != null) {
            protein = extras.getString("Protein")!!
            carb = extras.getString("Carb")!!
            time = extras.getInt("Time")
            lowCalorie = extras.getBoolean("LowCalorie")

            filterRecipes(recipeList, recipeView, protein!!, carb!!, time!!, lowCalorie)

        } else {
            // define list layout
            recipeView.adapter = RecipeListAdapter(
                this, R.layout.recipe_list_item, recipeList
            )

            // to remove warnings changed parameters that are not used to an underscore
            recipeView.setOnItemClickListener { _, _, i, _ ->
                showServingSizeDialog(i)
            }
        }

        // snack-bar to ask user if they would like to see original recipe
        recipeView.setOnItemLongClickListener { _, it, i, _ ->
            Snackbar.make(it, "Would you like to open the original recipe?", Snackbar.LENGTH_LONG)
                .setAction("OPEN LINK", openClickListener(i)).show()
            true
        }


        // floating action button
        val filterBtn: FloatingActionButton = findViewById(R.id.idFilterBtn)
        filterBtn.setOnClickListener {
            val intent = Intent(this, Activity4::class.java)
            startActivity(intent)
        }
    }

    private fun filterRecipes(recipeList: ArrayList<RecipeListModel>, recipeView: ListView, protein: String?, carb:String?, time: Int?, lowCalorie: Boolean ) {
        val holdList: ArrayList<RecipeListModel> = ArrayList()
        holdList.clear()
        filterList.clear()

        for (recipe in recipeList) {

            // real ugly nested if statements to get the filter to do what I want

            // if the low calorie switch is used it only adds the recipes that are low calorie
            // recipe.tags[3] == lowCalorie gave condition always true -- used true to avoid warning
            if (lowCalorie && recipe.tags[3] == true) {

                // i want time to take precedent so if the times don't line up don't show the recipe
                if (time!! != 0) {
                    val cookTime: Int = recipe.tags[2].toString().toInt()
                    if ((time > cookTime || time == cookTime) && protein!!.isEmpty() && carb!!.isEmpty()) {
                        holdList.add(recipe)
                    }
                    if ((time > cookTime || time == cookTime) && recipe.tags[0] == protein && recipe.tags[1] == carb) {
                        holdList.add(recipe)
                    }

                } else {
                    if (recipe.tags[0] == protein) holdList.add(recipe)

                    // this will allow recipes without a protein to show if just the switch is used or
                    //  the switch and an addition of noodles or rice is checked
                    if (protein!!.isEmpty()) holdList.add(recipe)

                    if (recipe.tags[1] == carb) holdList.add(recipe)
                }

            }

            // this is if the switch is not activated
            // but I still want it to show low calorie options -- so this is essentially filter all recipes
            // using user conditions
            if (!lowCalorie) {
                if (time!! != 0) {
                    val cookTime: Int = recipe.tags[2].toString().toInt()
                    if ((time > cookTime || time == cookTime) && protein!!.isEmpty() && carb!!.isEmpty()) {
                        holdList.add(recipe)
                    }
                    if ((time > cookTime || time == cookTime) && recipe.tags[0] == protein && recipe.tags[1] == carb) {
                        holdList.add(recipe)
                    }


                } else {
                    if (recipe.tags[0] == protein) holdList.add(recipe)

                    if (recipe.tags[1] == carb) holdList.add(recipe)
                }
            }
        } // for() recipe

        if (holdList.isEmpty()) {
            Toast.makeText(
                this@MainActivity, "Sorry there are no recipes with those options",
                Toast.LENGTH_LONG
            ).show()

            recipeView.adapter = RecipeListAdapter(
                this, R.layout.recipe_list_item, recipeList
            )
        } else {
            filterList.addAll(holdList.distinct()) // only keeps the recipe once
            recipeView.adapter = RecipeListAdapter(
                this, R.layout.recipe_list_item, filterList
            )
        }
        // to remove warnings changed parameters that are not used to an underscore
        recipeView.setOnItemClickListener { _, _, i, _ ->
            showServingSizeDialog(i)
        }
    }

    // snack-bar action
    // opens link to original recipe
    private fun openClickListener(i: Int): View.OnClickListener {
        val openResource = Intent(Intent.ACTION_VIEW)
        openResource.data = Uri.parse(recipeList[i].source)
        return View.OnClickListener {
            startActivity(openResource) }
    }

    @SuppressLint("InflateParams") // removes inflater error
    private fun showServingSizeDialog(i: Int) {
        // variables for dialog box
        // created to get the serving size from the user
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.serving_size_input, null)
        val numberPicker = dialogLayout.findViewById<NumberPicker>(R.id.idNumberPicker)

        // determines which recipe is being clicked
        var recipe = recipeList[i]
        // which recipe was clicked
        if (filterList.isNotEmpty()){
            recipe = filterList[i]
        }

        // get properties from recipe
        val ingredients: ArrayList<String> = ArrayList()
        for (item in recipe.ingredients){
            ingredients.add(item)
        }

        val ingredientAmounts: ArrayList<Double> = ArrayList()
        for (item in recipe.ingredientAmounts){
            ingredientAmounts.add(item)
        }

        val instructions: ArrayList<String> = ArrayList()
        for (item in recipe.instructions){
            instructions.add(item)
        }

        // initialize variable for adjusted amounts
        val adjustedAmounts: ArrayList<String> = ArrayList()

        // define number picker properties
        numberPicker.setMaxValue(12) // who's making more than 12 servings of soup?
        numberPicker.setMinValue(2) // recipes by default are one serving
        numberPicker.setWrapSelectorWheel(true)

        // create the dialog box with a number picker
        with(dialogBuilder){
            setTitle("How many servings would you like to make?")

            // dialog, which -> parameters never used changed to underscore to remove warning
            setPositiveButton("OK"){_, _ ->
                val servingSize = numberPicker.value // does nothing for now - but this is the variable for the user selected number

                // adjust serving size
                // change amount into string from a double for extra
                for (item in ingredientAmounts) {
                    val result: Double = item * servingSize
                    val formatResult = String.format("%.2f", result) // get rid of the ugly long decimals
                    adjustedAmounts.add(formatResult)
                }
                val intent = Intent(this@MainActivity, Activity2::class.java)

                intent.putStringArrayListExtra("Ingredients", ingredients)
                intent.putStringArrayListExtra("IngredientAmounts", adjustedAmounts)
                intent.putStringArrayListExtra("Instructions", instructions)

                startActivity(intent)
            }
            setNeutralButton("Just 1 Serving"){_, _ ->
                // recipes already adjusted to one serving
                // just need to change double in to string for extra
                for (item in ingredientAmounts) {
                    val formatItem = String.format("%.2f", item) // get rid of the ugly long decimals
                    adjustedAmounts.add(formatItem)
                }

                val intent = Intent(this@MainActivity, Activity2::class.java)

                intent.putStringArrayListExtra("Ingredients", ingredients)
                intent.putStringArrayListExtra("IngredientAmounts", adjustedAmounts)
                intent.putStringArrayListExtra("Instructions", instructions)

                startActivity(intent)
            }
            setNegativeButton("Go Back to Recipes"){_, _ ->
                Log.d("Main", "Negative button clicked")
            }
            setView(dialogLayout)
            show()
        }
    }
}