package com.example.pizzaapp.ui.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.R
import com.example.pizzaapp.domain.MenuRadioButton

class MenuAdItemsAdapter : ListAdapter<Int, MenuAdItemsAdapter.MenuAdItemsViewHolder>(DiffCallBack) {


    companion object DiffCallBack: DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }

    class MenuAdItemsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val context: Context = view.context
        val itemAd: ImageView = view.findViewById(R.id.ad_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdItemsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MenuAdItemsViewHolder(layoutInflater.inflate(R.layout.ad_item, parent, false))
    }

    override fun onBindViewHolder(holder: MenuAdItemsViewHolder, position: Int) {

        val item = getItem(position)
        with(holder) {
            itemAd.setImageResource(item)
        }
    }

}