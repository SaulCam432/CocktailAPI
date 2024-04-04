package com.saulcam.cocktailapi.model.server

import com.saulcam.cocktailapi.model.drink.Drinks
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksRoutes {
    @GET("search.php")
    suspend fun getDrinksByLetterA(
        @Query("f") letter: String
    ): Drinks

    @GET("lookup.php")
    suspend fun getDetailByID(
        @Query("i") id: String
    ): Drinks

    @GET("search.php")
    suspend fun getByName(
        @Query("s") search: String
    ): Drinks
}


object RetrofitServiceFactory {
    fun makeRetrofitServices(): DrinksRoutes {
        return Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(DrinksRoutes::class.java)
    }
}