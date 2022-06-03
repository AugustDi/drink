package com.triare.drinks.ui.drinks.not_alcoholic

import com.triare.drinks.data.NOT_ALCOHOLIC
import com.triare.drinks.ui.drinks.BaseDrinkViewModel

class NotAlcoholicDrinkViewModel: BaseDrinkViewModel() {
    override fun getQuery(): String {
        return NOT_ALCOHOLIC
    }

}