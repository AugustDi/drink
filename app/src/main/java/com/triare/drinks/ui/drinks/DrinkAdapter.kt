package com.triare.drinks.ui.drinks

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.triare.drinks.databinding.ItemDrinkBinding
import com.triare.drinks.ui.dvo.DrinkDvo

class DrinkAdapter(
    val context: Context,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>() {

    var items = emptyList<DrinkDvo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        return DrinkViewHolder(
            ItemDrinkBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class DrinkViewHolder(
        private val binding: ItemDrinkBinding
    ) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(item: DrinkDvo) {
            binding.apply {
                this.drinkName.text = item.drinkName

                Glide.with(context)
                    .load(item.drinkImg)
                    .centerInside()
                    .into(this.drinkImg)
            }
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(data = items[position])
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(data: DrinkDvo)
    }
}