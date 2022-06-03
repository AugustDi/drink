package com.triare.drinks.data.remote.rest.service

import com.triare.drinks.data.remote.rest.dto.DrinkDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkService {
    companion object {
        const val BASE_PATH = "www.thecocktaildb.com/api/json/v1/1/"
    }

    @GET("$BASE_PATH/filter.php")
    suspend fun getDrinks(
        @Query("a") a: String
    ): Response<DrinkDto>
}