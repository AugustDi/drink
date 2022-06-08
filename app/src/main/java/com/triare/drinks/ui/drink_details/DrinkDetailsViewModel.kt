package com.triare.drinks.ui.drink_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.triare.drinks.data.mapper.DrinkDetailsMapper
import com.triare.drinks.data.repository.DrinkRepository
import com.triare.drinks.ui.dvo.DrinkDetailsDvo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DrinkDetailsViewModel: ViewModel() {

    private val drinkRepository = DrinkRepository()

    private val _drinkDetailsLiveData = MutableLiveData<List<DrinkDetailsDvo>>()
    val drinkDetailsLiveData: LiveData<List<DrinkDetailsDvo>> = _drinkDetailsLiveData

    fun getDrinkDetails(query: String) {
        viewModelScope.launch(Dispatchers.Main) {
            val drinksDetails = drinkRepository.getDrinkDetails(query)
            if (drinksDetails.isSuccessful) {
                drinksDetails.body()?.let {
                    _drinkDetailsLiveData.value = DrinkDetailsMapper(it).map()
                }
            }
        }
    }
}