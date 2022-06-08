package com.triare.drinks.data.repository

import com.triare.drinks.data.remote.rest.Rest
import com.triare.drinks.data.remote.rest.dto.DrinkDetailsDto
import com.triare.drinks.data.remote.rest.dto.DrinkDto
import retrofit2.Response

class DrinkRepository {
    suspend fun getDrinks(query: String): Response<DrinkDto> {
        return Rest.apiService.getDrinks(query)
    }

    suspend fun getDrinkDetails(query: String): Response<DrinkDetailsDto> {
        return Rest.apiService.getDrinkDetails(query)
    }
}