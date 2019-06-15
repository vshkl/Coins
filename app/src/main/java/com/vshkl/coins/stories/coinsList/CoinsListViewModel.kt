package com.vshkl.coins.stories.coinsList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vshkl.coins.network.CoinrankingAPI
import com.vshkl.coins.network.models.Coins
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinsListViewModel : ViewModel() {

    private val coinsData: MutableLiveData<Coins> by lazy {
        MutableLiveData<Coins>()
    }
    private var offset = 0

    fun loadCoins() {
        fetchCoins()
    }

    fun loadMoreCoins() {
        offset += 50
        fetchCoins()
    }

    fun getCoins() = coinsData

    private fun fetchCoins() {
        CoinrankingAPI.instance.getCoins(offset).enqueue(object : Callback<Coins> {
            override fun onResponse(call: Call<Coins>, response: Response<Coins>) {
                if (response.isSuccessful) {
                    coinsData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Coins>, t: Throwable) {
                Log.d("CoinsListViewModel", t.toString())
//                coinsData.value = null
            }
        })
    }

}
