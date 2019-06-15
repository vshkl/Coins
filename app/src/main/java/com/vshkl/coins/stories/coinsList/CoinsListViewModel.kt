package com.vshkl.coins.stories.coinsList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vshkl.coins.network.CoinrankingAPI
import com.vshkl.coins.network.models.Coins
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinsListViewModel : ViewModel() {

    private lateinit var coinsData: MutableLiveData<Coins>

    fun init() {
        coinsData = fetchCoins()
    }

    fun getCoins() = coinsData

    private fun fetchCoins(): MutableLiveData<Coins> {
        val coinsData: MutableLiveData<Coins> = MutableLiveData()

        println("Fetching coins...")

        CoinrankingAPI.instance.getCoins().enqueue(object : Callback<Coins> {
            override fun onResponse(call: Call<Coins>, response: Response<Coins>) {
                println("Got response...")
                if (response.isSuccessful) {
                    coinsData.value = response.body()
                }
            }

            override fun onFailure(call: Call<Coins>, t: Throwable) {
                println("Got error...")
                println(t)
                coinsData.value = null
            }
        })

        return coinsData
    }

}
