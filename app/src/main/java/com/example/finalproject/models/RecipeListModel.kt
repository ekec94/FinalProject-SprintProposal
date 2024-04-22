package com.example.finalproject.models

data class RecipeListModel(
    val recipeName: String,
    val cookTime: String,
    val img: Int,
    val ingredients: List<String>,
    val ingredientAmounts: List<Double>,
    val instructions: List<String>,
    val source: String,
    val tags: List<Any>

)