package com.vshkl.coins.stories.coinsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.vshkl.coins.repository.Repository
import com.vshkl.coins.stories.models.Coin
import com.vshkl.coins.stories.models.Mappers

class CoinsListViewModel : ViewModel() {

    private val coinsData: LiveData<List<Coin>> by lazy {
        Transformations.map(Repository.fetchCoins(0)) { coinsData ->
            Mappers.mapCoins(coinsData.data.coins)
        }
    }

    fun getCoins() = coinsData
    
}
