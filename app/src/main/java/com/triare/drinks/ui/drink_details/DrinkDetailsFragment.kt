package com.triare.drinks.ui.drink_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.triare.drinks.databinding.FragmentDrinkDetailsBinding
import com.triare.drinks.ui.dvo.DrinkDvo

class DrinkDetailsFragment : Fragment() {

    private lateinit var drinkDetailsAdapter: IngredientAdapter
    private val drinkDetailsViewModel by viewModels<DrinkDetailsViewModel>()
    private val binding: FragmentDrinkDetailsBinding by viewBinding(CreateMethod.INFLATE)
    private var dataDrink: DrinkDvo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initArgs()
    }

    private fun initArgs() {
        arguments?.let {
            if (it.containsKey(KEY_DATA_DRINK_ARGS)) {
                dataDrink = arguments?.get(KEY_DATA_DRINK_ARGS) as DrinkDvo?
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        observeIngredients()
    }


    private fun initUi() {
        initToolBar()
        initDetailsGrid()
        initDrinkIcon()
    }

    private fun observeIngredients() {
        drinkDetailsViewModel.getDrinkDetails(dataDrink!!.drinkId)
        drinkDetailsViewModel.drinkDetailsLiveData.observe(viewLifecycleOwner) {
            binding.instructions.text = it[0].instruction
            drinkDetailsAdapter.items = it[0].ingredient
        }
    }

    private fun initToolBar() {
        binding.topAppBar.title = dataDrink?.drinkName
        binding.topAppBar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun initDetailsGrid() {
        val drinkDetailsGrid = binding.ingredientRecyclerGrid
        drinkDetailsGrid.apply {
            layoutManager =
                GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
            drinkDetailsAdapter = IngredientAdapter(context)
            adapter = drinkDetailsAdapter
        }
    }

    private fun initDrinkIcon() {
        Glide.with(requireContext())
            .load(dataDrink?.drinkImg)
            .into(binding.drinkIcon)
    }

    companion object {
        private const val KEY_DATA_DRINK_ARGS = "OverviewRef"
        fun newInstance(dataDrink: DrinkDvo): DrinkDetailsFragment {
            val args = bundleOf(KEY_DATA_DRINK_ARGS to dataDrink)

            val drinkDetailsFragment = DrinkDetailsFragment()
            drinkDetailsFragment.arguments = args

            return drinkDetailsFragment
        }
    }
}