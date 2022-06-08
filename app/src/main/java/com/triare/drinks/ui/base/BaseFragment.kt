package com.triare.drinks.ui.base

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.triare.drinks.R
import com.triare.drinks.databinding.FragmentBaseBinding
import com.triare.drinks.ui.drink_details.DrinkDetailsFragment
import com.triare.drinks.ui.drinks.BaseDrinkViewModel
import com.triare.drinks.ui.drinks.DrinkAdapter
import com.triare.drinks.ui.dvo.DrinkDvo

abstract class BaseFragment : Fragment(), DrinkAdapter.OnItemClickListener {

    protected val binding: FragmentBaseBinding by viewBinding(CreateMethod.INFLATE)
    protected lateinit var drinkAdapter: DrinkAdapter
    abstract val viewModel: BaseDrinkViewModel

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

    private fun initRecyclerView() {
        val drinkRecycler = binding.recyclerViewAlcDrinks
        drinkRecycler.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            drinkAdapter = DrinkAdapter(context, this@BaseFragment)
            adapter = drinkAdapter
        }

        addItemMargin()
    }

    override fun onItemClick(data: DrinkDvo) {
        val drinkDetails = DrinkDetailsFragment.newInstance(data)
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.navHostFragment, drinkDetails)
            .addToBackStack("")
            .commit()
    }

    abstract fun getTitle(): Int

    private fun initTitle() {
        binding.title.text = getText(getTitle())
    }

    private fun observeDrinks() {
        viewModel.drinkLiveData.observe(viewLifecycleOwner) {
            drinkAdapter.items = it
        }
    }

    private fun addItemMargin() {
        binding.apply {
            recyclerViewAlcDrinks.addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    val bottomMargin = resources.getDimensionPixelSize(R.dimen.item_bottom_margin)
                    outRect.apply {
                        bottom = bottomMargin
                    }
                }
            })
        }
    }
}