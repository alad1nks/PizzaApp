package com.example.pizzaapp.ui.menu

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.R
import com.example.pizzaapp.domain.MenuRadioButton
import kotlinx.coroutines.selects.select


class MenuRadioButtonsAdapter : ListAdapter<MenuRadioButton, MenuRadioButtonsAdapter.MenuRadioButtonsViewHolder>(DiffCallBack) {

    private var selectedPosition = 0

    companion object DiffCallBack: DiffUtil.ItemCallback<MenuRadioButton>() {
        override fun areItemsTheSame(oldItem: MenuRadioButton, newItem: MenuRadioButton): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: MenuRadioButton, newItem: MenuRadioButton): Boolean {
            return oldItem.name == newItem.name
        }
    }

    class MenuRadioButtonsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val context: Context = view.context
        val itemMenuRadioButton: CheckBox = view.findViewById(R.id.radioButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuRadioButtonsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MenuRadioButtonsViewHolder(layoutInflater.inflate(R.layout.menu_radio_button, parent, false))
    }

    override fun onBindViewHolder(holder: MenuRadioButtonsViewHolder, position: Int) {

        val item = getItem(position)
        with(holder) {
            itemMenuRadioButton.text = item.name
            itemMenuRadioButton.isChecked = item.checked
            itemMenuRadioButton.setOnClickListener {
                getItem(selectedPosition).checked = false
                notifyItemChanged(selectedPosition)
                selectedPosition = holder.adapterPosition
                getItem(selectedPosition).checked = true
                notifyItemChanged(selectedPosition)
            }
        }
    }

}