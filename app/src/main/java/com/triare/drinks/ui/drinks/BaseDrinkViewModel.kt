package com.triare.drinks.ui.drinks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.triare.drinks.data.mapper.DrinksMapper
import com.triare.drinks.data.repository.DrinkRepository
import com.triare.drinks.ui.dvo.DrinkDvo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseDrinkViewModel : ViewModel() {

    private val drinkRepository = DrinkRepository()

    private val _drinkLiveData = MutableLiveData<List<DrinkDvo>>()
    val drinkLiveData: LiveData<List<DrinkDvo>> = _drinkLiveData

    abstract fun getQuery(): String

    init {
        getDrinks()
    }

    private fun getDrinks() {

        viewModelScope.launch(Dispatchers.Main) {
            val drinks = drinkRepository.getDrinks(getQuery())
            if (drinks.isSuccessful) {
                drinks.body()?.let {
                    _drinkLiveData.value = DrinksMapper(it).map()
                }
            }
        }
    }
}