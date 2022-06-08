package com.triare.drinks.data.mapper

import com.triare.drinks.data.remote.rest.dto.DrinkDetailsDto
import com.triare.drinks.ui.dvo.DrinkDetailsDvo
import com.triare.drinks.ui.dvo.DrinkIngredientDvo

class DrinkDetailsMapper(private val drinkDerailsDto: DrinkDetailsDto) {

    fun map(): List<DrinkDetailsDvo> {
        return drinkDerailsDto.drinks.map {

            DrinkDetailsDvo(
                it.strInstructions.orEmpty(),
                getDrinkIngredientList(
                    listOf(
                        it.strIngredient1,
                        it.strIngredient2,
                        it.strIngredient3,
                        it.strIngredient4,
                        it.strIngredient5,
                        it.strIngredient6,
                        it.strIngredient7,
                        it.strIngredient8,
                        it.strIngredient9,
                        it.strIngredient10,
                        it.strIngredient11,
                        it.strIngredient12,
                        it.strIngredient13,
                        it.strIngredient14,
                        it.strIngredient15
                    )
                )
            )
        }
    }

    companion object {
        private fun createIngredientIconUrl(s: String): String {
            return "https://www.thecocktaildb.com/images/ingredients/${
                s.replace(
                    " ",
                    "%20"
                )
            }-Medium.png"
        }

        fun getDrinkIngredientList(ingredientList: List<String?>): List<DrinkIngredientDvo> {
            val ingredientItemList: MutableList<DrinkIngredientDvo> = mutableListOf()

            ingredientList.forEach {
                if (it != null) {
                    ingredientItemList.add(
                        DrinkIngredientDvo(
                            it,
                            createIngredientIconUrl(it)
                        )
                    )
                }
            }
            return ingredientItemList
        }
    }
}