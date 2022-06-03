package com.triare.drinks.ui.drinks.alcoholic

import com.triare.drinks.data.ALCOHOLIC
import com.triare.drinks.ui.drinks.BaseDrinkViewModel

class AlcoholicDrinkViewModel : BaseDrinkViewModel() {
    override fun getQuery(): String {
        return ALCOHOLIC
    }

}