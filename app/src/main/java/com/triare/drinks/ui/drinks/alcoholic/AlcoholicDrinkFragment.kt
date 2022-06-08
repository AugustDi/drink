package com.triare.drinks.ui.drinks.alcoholic

import androidx.fragment.app.viewModels
import com.triare.drinks.R
import com.triare.drinks.ui.base.BaseFragment
import com.triare.drinks.ui.drinks.BaseDrinkViewModel
import com.triare.drinks.ui.dvo.DrinkDvo

class AlcoholicDrinkFragment : BaseFragment() {

    override val viewModel: BaseDrinkViewModel by viewModels<AlcoholicDrinkViewModel>()

    override fun getTitle(): Int {
        return R.string.popular_alcoholic_drinks
    }
}