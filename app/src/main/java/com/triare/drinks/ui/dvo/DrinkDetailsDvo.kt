package com.triare.drinks.ui.dvo

data class DrinkDetailsDvo(
    val instruction: String,
    val ingredient: List<DrinkIngredientDvo>
)

data class DrinkIngredientDvo(
    val ingredientName: String,
    val ingredientIcon: String
)