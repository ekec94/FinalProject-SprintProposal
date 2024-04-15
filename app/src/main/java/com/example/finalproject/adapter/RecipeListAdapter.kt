package com.example.custlistviewproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.finalproject.R

class RecipeListAdapter(val ctx: Context, val ourResource: Int,
                      val items: ArrayList<RecipeListModel>): ArrayAdapter<RecipeListModel>(ctx,ourResource,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(ourResource, null)

        // variables for layout views
        val title = view.findViewById<TextView>(R.id.idRecipeName)
        val author = view.findViewById<TextView>(R.id.idRecipeTime)
        val img = view.findViewById<ImageView>(R.id.idRecipeImage)

        // model
        title.text = items[position].recipeName
        author.text = items[position].prepTime
        img.setImageDrawable(ctx.resources.getDrawable(items[position].img))

        return view
    }
}