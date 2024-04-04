package com.saulcam.cocktailapi.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.saulcam.cocktailapi.ui.adapters.ingredients.CocktailIngredientsAdapter
import com.saulcam.cocktailapi.model.server.RetrofitServiceFactory
import com.saulcam.cocktailapi.databinding.ActivityDetailsBinding
import com.saulcam.cocktailapi.model.drink.Drink
import com.saulcam.cocktailapi.model.ingredient.Ingredient
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    var drinkC: String? = null
    var drink = ArrayList<Drink>()
    var services = RetrofitServiceFactory.makeRetrofitServices()
    var adapter: CocktailIngredientsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drinkC = intent.getStringExtra("idDrink")

        binding.rvListIngredients.layoutManager = LinearLayoutManager(this@DetailsActivity)
        binding.rvListIngredients.setHasFixedSize(true)

        lifecycleScope.launch {
            val drinkDetail = services.getDetailByID(drinkC!!)
            withContext(Dispatchers.Main) {
                drink.clear()
                drink.add(drinkDetail.drinks[0])
                getData(drink)

                var ingredient: MutableList<Ingredient> = ArrayList()

                // Verificar cada ingrediente antes de agregarlo a la lista
                if (!drinkDetail.drinks[0].strIngredient1.isNullOrEmpty()) {
                    val ingredientes1 = Ingredient(drinkDetail.drinks[0].strIngredient1, drinkDetail.drinks[0].strMeasure1)
                    ingredient.add(ingredientes1)
                }

                if (!drinkDetail.drinks[0].strIngredient2.isNullOrEmpty()) {
                    val ingredientes2 = Ingredient(drinkDetail.drinks[0].strIngredient2, drinkDetail.drinks[0].strMeasure2)
                    ingredient.add(ingredientes2)
                }

                if (!drinkDetail.drinks[0].strIngredient3.isNullOrEmpty()) {
                    val ingredientes3 = Ingredient(drinkDetail.drinks[0].strIngredient3, drinkDetail.drinks[0].strMeasure3)
                    ingredient.add(ingredientes3)
                }

                if (!drinkDetail.drinks[0].strIngredient4.isNullOrEmpty()) {
                    val ingredientes4 = Ingredient(drinkDetail.drinks[0].strIngredient4, drinkDetail.drinks[0].strMeasure4)
                    ingredient.add(ingredientes4)
                }

                if (!drinkDetail.drinks[0].strIngredient5.isNullOrEmpty()) {
                    val ingredientes5 = Ingredient(drinkDetail.drinks[0].strIngredient5, drinkDetail.drinks[0].strMeasure5)
                    ingredient.add(ingredientes5)
                }

                if (!drinkDetail.drinks[0].strIngredient6.isNullOrEmpty()) {
                    val ingredientes6 = Ingredient(drinkDetail.drinks[0].strIngredient6, drinkDetail.drinks[0].strMeasure6)
                    ingredient.add(ingredientes6)
                }

                if (!drinkDetail.drinks[0].strIngredient7.isNullOrEmpty()) {
                    val ingredientes7 = Ingredient(drinkDetail.drinks[0].strIngredient7, drinkDetail.drinks[0].strMeasure7)
                    ingredient.add(ingredientes7)
                }

                if (!drinkDetail.drinks[0].strIngredient8.isNullOrEmpty()) {
                    val ingredientes8 = Ingredient(drinkDetail.drinks[0].strIngredient8, drinkDetail.drinks[0].strMeasure8)
                    ingredient.add(ingredientes8)
                }

                if (!drinkDetail.drinks[0].strIngredient9.isNullOrEmpty()) {
                    val ingredientes9 = Ingredient(drinkDetail.drinks[0].strIngredient9, drinkDetail.drinks[0].strMeasure9)
                    ingredient.add(ingredientes9)
                }

                if (!drinkDetail.drinks[0].strIngredient10.isNullOrEmpty()) {
                    val ingredientes10 = Ingredient(drinkDetail.drinks[0].strIngredient10, drinkDetail.drinks[0].strMeasure10)
                    ingredient.add(ingredientes10)
                }

                if (!drinkDetail.drinks[0].strIngredient11.isNullOrEmpty()) {
                    val ingredientes11 = Ingredient(drinkDetail.drinks[0].strIngredient11, drinkDetail.drinks[0].strMeasure11)
                    ingredient.add(ingredientes11)
                }

                if (!drinkDetail.drinks[0].strIngredient12.isNullOrEmpty()) {
                    val ingredientes12 = Ingredient(drinkDetail.drinks[0].strIngredient12, drinkDetail.drinks[0].strMeasure12)
                    ingredient.add(ingredientes12)
                }

                if (!drinkDetail.drinks[0].strIngredient13.isNullOrEmpty()) {
                    val ingredientes13 = Ingredient(drinkDetail.drinks[0].strIngredient13, drinkDetail.drinks[0].strMeasure13)
                    ingredient.add(ingredientes13)
                }

                if (!drinkDetail.drinks[0].strIngredient14.isNullOrEmpty()) {
                    val ingredientes14 = Ingredient(drinkDetail.drinks[0].strIngredient14, drinkDetail.drinks[0].strMeasure14)
                    ingredient.add(ingredientes14)
                }

                if (!drinkDetail.drinks[0].strIngredient15.isNullOrEmpty()) {
                    val ingredientes15 = Ingredient(drinkDetail.drinks[0].strIngredient15, drinkDetail.drinks[0].strMeasure15)
                    ingredient.add(ingredientes15)
                }

                adapter = CocktailIngredientsAdapter(this@DetailsActivity, ingredient)
                binding.rvListIngredients.adapter = adapter
            }
        }
    }

    private fun getData(drink: ArrayList<Drink>){
        Picasso.get().load(drink[0].strDrinkThumb).into(binding.imgViewCocktailDetail)
        binding.txtNameDetail.text = drink[0].strDrink
        binding.txtInstructionsDetail.text = drink[0].strInstructions
    }

}