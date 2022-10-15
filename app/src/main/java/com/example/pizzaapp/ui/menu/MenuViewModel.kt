package com.example.pizzaapp.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzaapp.domain.MenuRadioButton
import com.example.pizzaapp.domain.Product
import com.example.pizzaapp.repositories.menu.MenuRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val menuRepository: MenuRepository
) : ViewModel() {

    val menuRadioButtons = MutableLiveData<List<MenuRadioButton>>()

    val products = MutableLiveData<List<Product>>()

    val adItems = MutableLiveData<List<Int>>()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            menuRadioButtons.postValue(menuRepository.getRadioButtons())
            adItems.postValue(menuRepository.getAdItems())
            try {
                products.postValue(menuRepository.getProductsApi())
            } catch (e: IOException) {
                products.postValue(menuRepository.getProducts())
            }
        }
    }
}