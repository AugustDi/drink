package com.triare.drinks.data.remote.rest.service

import com.triare.drinks.data.remote.rest.dto.DrinkDetailsDto
import com.triare.drinks.data.remote.rest.dto.DrinkDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkService {

    @GET("filter.php")
    suspend fun getDrinks(
        @Query("a") a: String
    ): Response<DrinkDto>

    @GET("lookup.php")
    suspend fun getDrinkDetails(
        @Query("i") a: String
    ): Response<DrinkDetailsDto>
}