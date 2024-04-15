package com.example.finalproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import com.example.finalproject.R
import com.example.finalproject.models.IngredientListModel

class IngredientListAdapter (val ctx: Context, val ourResource: Int,
                             val items: ArrayList<IngredientListModel>): ArrayAdapter<IngredientListModel>(ctx,ourResource,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(ourResource, null)

        // variables for layout views
        val ingredient = view.findViewById<CheckBox>(R.id.idCheckBox)

        // model
        ingredient.text = items[position].ingredient


        return view
    }
}