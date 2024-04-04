package com.saulcam.cocktailapi.ui.adapters.cocktailList

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.saulcam.cocktailapi.databinding.CardviewListCocktailsBinding
import com.saulcam.cocktailapi.model.drink.Drink
import com.saulcam.cocktailapi.ui.view.DetailsActivity
import com.squareup.picasso.Picasso

class CoctailListViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = CardviewListCocktailsBinding.bind(view)


    fun bind(context: Activity, drink: Drink){
        binding.textCocktailName.text = drink.strDrink
        binding.textCocktailType.text = drink.strAlcoholic

        Picasso.get().load(drink.strDrinkThumb).into(binding.imgCocktail)

        binding.imgCocktail.setOnClickListener {
            goToDetailActivity(context, drink)
        }

    }

    private fun goToDetailActivity(context: Activity, drink: Drink){
        val i = Intent(context, DetailsActivity::class.java)
        i.putExtra("idDrink", drink.idDrink)
        context.startActivity(i)
    }
}