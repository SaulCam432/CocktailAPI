package com.saulcam.cocktailapi.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.saulcam.cocktailapi.ui.adapters.cocktailList.CocktailListAdapter
import com.saulcam.cocktailapi.model.server.RetrofitServiceFactory
import com.saulcam.cocktailapi.databinding.ActivityMainBinding
import com.saulcam.cocktailapi.model.drink.Drink
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var drinks = ArrayList<Drink>()
    var searchDrink = ArrayList<Drink>()
    val services = RetrofitServiceFactory.makeRetrofitServices()
    var adapter: CocktailListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListCocktails.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvListCocktails.setHasFixedSize(true)

        getCocktailsByLetterA("a")
        filterByLetter()

        binding.btnSearchByName.setOnClickListener{
            val searchCocktail = binding.etSearchByName.text.toString()
            if(!searchCocktail.isNullOrEmpty()){
                searchByName(searchCocktail)
            }else{
                Toast.makeText(this@MainActivity, "Insert a value to search", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getCocktailsByLetterA(l: String){
        lifecycleScope.launch {
            val bebidas = services.getDrinksByLetterA(l)
            withContext(Dispatchers.Main) {

                if(!bebidas.drinks.isNullOrEmpty()){
                    drinks.clear()
                    drinks.addAll(bebidas.drinks)
                    adapter = CocktailListAdapter(this@MainActivity, drinks)
                    binding.rvListCocktails.adapter = adapter
                }else{
                    Toast.makeText(this@MainActivity, "There aren't drinks with letter: $l ", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun searchByName(cocktail: String){
        lifecycleScope.launch {
            val search = services.getByName(cocktail)
            withContext(Dispatchers.Main) {
                drinks.clear()
                drinks.addAll(search.drinks)

                //Log.d("busquedsa", "${search.drinks}")
                adapter = CocktailListAdapter(this@MainActivity, drinks)
                binding.rvListCocktails.adapter = adapter
            }
        }
    }


    private fun filterByLetter(){
        val letter = arrayListOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
        val arrayAdapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_dropdown_item_1line, letter)
        binding.spinnerFilterLetter.adapter = arrayAdapter
        binding.spinnerFilterLetter.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterview: AdapterView<*>?, view: View?, position: Int, l: Long) {
                getCocktailsByLetterA(letter[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
    }


}
