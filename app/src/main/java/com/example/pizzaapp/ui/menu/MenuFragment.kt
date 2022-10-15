package com.example.pizzaapp.ui.menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.PizzaApp
import com.example.pizzaapp.databinding.FragmentMenuBinding
import javax.inject.Inject

class MenuFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MenuViewModel> { viewModelFactory }

    private var _binding: FragmentMenuBinding? = null

    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as PizzaApp).appComponent.menuComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MenuRadioButtonsAdapter()
        binding.holder.menuRecycler.adapter = adapter
        binding.holder.menuRecycler.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        viewModel.menuRadioButtons.observe(viewLifecycleOwner) {
            it?.let {
                adapter.submitList(it)
            }
        }

        val productsAdapter = MenuProductsAdapter()
        binding.productRecycler.adapter = productsAdapter
        binding.productRecycler.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        viewModel.products.observe(viewLifecycleOwner) {
            it?.let {
                productsAdapter.submitList(it)
            }
        }

        val adItemsAdapter = MenuAdItemsAdapter()
        binding.adItemsRecycler.adapter = adItemsAdapter
        binding.adItemsRecycler.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        viewModel.adItems.observe(viewLifecycleOwner) {
            it?.let {
                adItemsAdapter.submitList(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}