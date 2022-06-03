package com.triare.drinks.ui.drinks

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.triare.drinks.ui.drinks.alcoholic.AlcoholicDrinkFragment
import com.triare.drinks.ui.drinks.not_alcoholic.NotAlcoholicDrinkFragment

class DrinksPagerAdapter(fa: FragmentActivity) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AlcoholicDrinkFragment()
            1 -> NotAlcoholicDrinkFragment()
            else -> {
                Fragment()
            }
        }
    }
}