package com.triare.drinks.ui.drinks.not_alcoholic

import androidx.fragment.app.viewModels
import com.triare.drinks.R
import com.triare.drinks.ui.base.BaseFragment
import com.triare.drinks.ui.drinks.BaseDrinkViewModel
import com.triare.drinks.ui.dvo.DrinkDvo

class NotAlcoholicDrinkFragment() : BaseFragment() {

    override val viewModel: BaseDrinkViewModel by viewModels<NotAlcoholicDrinkViewModel>()

    override fun getTitle(): Int {
        return R.string.popular_not_alcoholic_drinks
    }
}