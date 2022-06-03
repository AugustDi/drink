package com.triare.drinks.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.triare.drinks.R
import com.triare.drinks.databinding.ActivityMainBinding
import com.triare.drinks.ui.drinks.alcoholic.AlcoholicDrinkFragment
import com.triare.drinks.ui.drinks.not_alcoholic.NotAlcoholicDrinkFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(CreateMethod.INFLATE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initUi()
    }

    private fun initUi() {
        initBottomNav()
    }

    private fun initBottomNav() {
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.alcoholicDrinkFragment -> replaceFragment(AlcoholicDrinkFragment())
                R.id.notAlcoholicFragment -> replaceFragment(NotAlcoholicDrinkFragment())
            }
            true
        }
    }

    private fun replaceFragment(fr: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.navHostFragment, fr)
            .addToBackStack("test")
            .commit()
    }
}