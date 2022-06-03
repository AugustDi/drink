package com.triare.drinks.data.remote.rest.dto

data class DrinkDto(
	val drinks: List<DrinkItem>
)

data class DrinkItem(
	val strDrink: String,
	val strDrinkThumb: String,
	val idDrink: String
)

