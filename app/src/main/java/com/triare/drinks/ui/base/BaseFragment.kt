package com.triare.drinks.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.triare.drinks.R
import com.triare.drinks.databinding.FragmentBaseBinding
import com.triare.drinks.ui.drinks.DrinkAdapter
import com.triare.drinks.ui.dvo.DrinkDvo

abstract class BaseFragment : Fragment() {

    protected val binding: FragmentBaseBinding by viewBinding(CreateMethod.INFLATE)
    protected lateinit var drinkAdapter: DrinkAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
    }

    private fun initUi() {
        initRecyclerView()
        initTitle()
        observeDrinks()
    }

    private fun initTitle() {
        binding.title.text = getText(getTitle())
    }

    private fun observeDrinks() {

    }

    abstract fun getTitle(): Int

    private fun initRecyclerView() {
        val drinkRecycler = binding.recyclerViewAlcDrinks
        drinkRecycler.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            drinkAdapter = DrinkAdapter(context)
            adapter = drinkAdapter
        }
    }
}