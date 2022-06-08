package com.triare.drinks.ui.dvo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DrinkDvo(
    val drinkImg: String,
    val drinkName: String,
    val drinkId: String
) :Parcelable
