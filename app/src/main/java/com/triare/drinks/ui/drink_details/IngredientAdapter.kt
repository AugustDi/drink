package com.triare.drinks.ui.drink_details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.triare.drinks.databinding.ItemGridIngredientBinding
import com.triare.drinks.ui.dvo.DrinkIngredientDvo

class IngredientAdapter(
    val context: Context,
) : RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>() {

    var items = emptyList<DrinkIngredientDvo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        return IngredientViewHolder(
            ItemGridIngredientBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class IngredientViewHolder(
        private val binding: ItemGridIngredientBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DrinkIngredientDvo) {
            binding.apply {
                this.ingredientName.text = item.ingredientName

                Glide.with(context)
                    .load(item.ingredientIcon)
                    .centerCrop()
                    .into(this.ingredientIcon)
            }
        }
    }
}