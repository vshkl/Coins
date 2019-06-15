package com.vshkl.coins.network

import androidx.lifecycle.LiveData
import com.vshkl.coins.network.models.Coin
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

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
    fun getCoins(): LiveData<List<Coin>>

}