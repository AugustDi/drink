package com.triare.drinks.data.mapper

import com.triare.drinks.data.remote.rest.dto.DrinkDto
import com.triare.drinks.ui.dvo.DrinkDvo

class DrinksMapper(private val drinkDto: DrinkDto) {
    fun map(): List<DrinkDvo> {
        return drinkDto.drinks.map {
            DrinkDvo(
                it.strDrinkThumb,
                it.strDrink,
                it.idDrink
            )
        }
    }
}