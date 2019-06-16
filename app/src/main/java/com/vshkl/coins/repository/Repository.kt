package com.vshkl.coins.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vshkl.coins.network.CoinrankingAPI
import com.vshkl.coins.network.models.Coins
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {

    fun fetchCoins(offset: Int): LiveData<Coins> {
        val coinsData: MutableLiveData<Coins> by lazy {
            MutableLiveData<Coins>()
        }

        CoinrankingAPI.instance.getCoins(offset).enqueue(object : Callback<Coins> {
            override fun onResponse(call: Call<Coins>, response: Response<Coins>) {
                if (response.isSuccessful) {
                    coinsData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Coins>, t: Throwable) {
                Log.d("Repository.fetchCoins", t.toString())
            }
        })

        return coinsData
    }

}