package com.example.custlistviewproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.finalproject.R
import com.example.finalproject.models.RecipeListModel

class RecipeListAdapter(val ctx: Context, val ourResource: Int,
                      val items: ArrayList<RecipeListModel>): ArrayAdapter<RecipeListModel>(ctx,ourResource,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(ourResource, null)

        // variables for layout views
        val name = view.findViewById<TextView>(R.id.idRecipeName)
        val time = view.findViewById<TextView>(R.id.idRecipeTime)
        val img = view.findViewById<ImageView>(R.id.idRecipeImage)

        // model
        name.text = items[position].recipeName
        time.text = items[position].cookTime
        img.setImageDrawable(ctx.resources.getDrawable(items[position].img))
        items[position].ingredients
        items[position].ingredientAmounts
        items[position].instructions
        items[position].source
        items[position].tags

        return view
    }
}