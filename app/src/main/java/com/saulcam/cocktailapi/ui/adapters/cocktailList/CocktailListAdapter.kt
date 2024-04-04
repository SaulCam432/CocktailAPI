package com.saulcam.cocktailapi.ui.adapters.cocktailList

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saulcam.cocktailapi.R
import com.saulcam.cocktailapi.model.drink.Drink

class CocktailListAdapter (val context: Activity, val drinks: ArrayList<Drink>): RecyclerView.Adapter<CoctailListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoctailListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CoctailListViewHolder(layoutInflater.inflate(R.layout.cardview_list_cocktails, parent, false))
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    override fun onBindViewHolder(holder: CoctailListViewHolder, position: Int) {
        val drinksPosition = drinks[position]
        holder.bind(context, drinksPosition)
    }
}