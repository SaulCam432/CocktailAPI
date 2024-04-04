package com.saulcam.cocktailapi.ui.adapters.ingredients

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.saulcam.cocktailapi.databinding.CardviewListIngredientsBinding
import com.saulcam.cocktailapi.model.ingredient.Ingredient

class CoctailIngredientsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = CardviewListIngredientsBinding.bind(view)

    fun bind(context: Activity, ingredients: Ingredient){
            binding.tvIngredientList.text = ingredients.ingredient.toString()
            binding.tvMeasureList.text = ingredients.measure.toString()
    }
}