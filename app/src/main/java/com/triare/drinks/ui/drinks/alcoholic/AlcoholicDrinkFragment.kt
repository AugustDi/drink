package com.triare.drinks.ui.drinks.alcoholic

import androidx.fragment.app.viewModels
import com.triare.drinks.R
import com.triare.drinks.ui.base.BaseFragment
import com.triare.drinks.ui.dvo.DrinkDvo

class AlcoholicDrinkFragment : BaseFragment() {

    private val alcDrinkViewModel by viewModels<AlcoholicDrinkViewModel>()

    override fun getTitle(): Int {
        return R.string.popular_alcoholic_drinks
    }

    override fun getDrinks(): List<DrinkDvo> {
        TODO("Not yet implemented")
    }
}