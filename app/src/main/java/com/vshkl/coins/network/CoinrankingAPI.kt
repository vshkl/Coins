package com.vshkl.coins.network

import com.vshkl.coins.network.models.Coins
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinrankingAPI {

    companion object {
        val instance: CoinrankingAPI by lazy {
            Retrofit.Builder()
                .baseUrl("https://api.coinranking.com/v1/public/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(CoinrankingAPI::class.java)
        }
    }

    @GET("coins")
    fun getCoins(@Query("offset") offset: Int): Call<Coins>

}