package com.example.pizzaapp.ui.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.R
import com.example.pizzaapp.databinding.ProductItemBinding
import com.example.pizzaapp.domain.Product

class MenuProductsAdapter : ListAdapter<Product, MenuProductsAdapter.MenuProductsViewHolder>(DiffCallBack) {

    companion object DiffCallBack: DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.ingredients == newItem.ingredients
        }
    }

    class MenuProductsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val context: Context = view.context
        val nameProduct = view.findViewById<TextView>(R.id.product_name)
        val ingredientsProduct = view.findViewById<TextView>(R.id.product_ingredients)
        val imageProduct = view.findViewById<ImageView>(R.id.product_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuProductsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MenuProductsViewHolder(layoutInflater.inflate(R.layout.product_item, parent, false))
    }

    override fun onBindViewHolder(holder: MenuProductsViewHolder, position: Int) {
        val item = getItem(position)
        with(holder) {
            nameProduct.text = item.name
            ingredientsProduct.text = item.ingredients
            imageProduct.setImageResource(item.image)
        }
    }

}