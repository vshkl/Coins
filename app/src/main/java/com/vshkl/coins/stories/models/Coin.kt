package com.vshkl.coins.stories.models

data class Coin(
    val rank: String,
    val name: String,
    val symbol: String,
    val iconUrl: String,
    val price: String,
    val change: String,
    val marketCap: String
)