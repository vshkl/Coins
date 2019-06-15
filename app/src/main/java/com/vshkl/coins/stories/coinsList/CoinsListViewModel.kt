package com.vshkl.coins.stories.coinsList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vshkl.coins.network.CoinrankingAPI
import com.vshkl.coins.network.models.Coins
import com.vshkl.coins.stories.Mappers
import com.vshkl.coins.stories.models.Coin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinsListViewModel : ViewModel() {

    private val coinsData: MutableLiveData<List<Coin>> by lazy {
        MutableLiveData<List<Coin>>()
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

    // TODO: Extract to the repository
    private fun fetchCoins() {
        CoinrankingAPI.instance.getCoins(offset).enqueue(object : Callback<Coins> {
            override fun onResponse(call: Call<Coins>, response: Response<Coins>) {
                if (response.isSuccessful) {
                    coinsData.postValue(response.body()?.data?.coins?.let { Mappers.mapCoins(it) })
                }
            }

            override fun onFailure(call: Call<Coins>, t: Throwable) {
                Log.d("CoinsListViewModel", t.toString())
            }
        })
    }

}
