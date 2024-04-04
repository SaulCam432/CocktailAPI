package com.saulcam.cocktailapi.ui.adapters.ingredients

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saulcam.cocktailapi.R
import com.saulcam.cocktailapi.model.ingredient.Ingredient

class CocktailIngredientsAdapter(val context: Activity, val ingredients: MutableList<Ingredient>): RecyclerView.Adapter<CoctailIngredientsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoctailIngredientsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CoctailIngredientsViewHolder(layoutInflater.inflate(R.layout.cardview_list_ingredients, parent, false))
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    override fun onBindViewHolder(holder: CoctailIngredientsViewHolder, position: Int) {
        val ingredientsPosition = ingredients[position]

        holder.bind(context, ingredientsPosition)

    }
}