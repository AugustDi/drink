package com.triare.drinks.extensions

import android.view.View
import com.triare.drinks.base.OnSingleClickListener

/**
 * Make one click for button
 */
fun View.setOnSingleClickListener(l: View.OnClickListener) {
    setOnClickListener(OnSingleClickListener(l))
}

fun View.setOnSingleClickListener(l: (View) -> Unit) {
    setOnClickListener(OnSingleClickListener(l))
}