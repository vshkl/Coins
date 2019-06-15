package com.vshkl.coins.network.models

data class Coin(
    val id: Int,
    val rank: Int,
    val symbol: String,
    val name: String,
    val iconUrl: String,
    val price: Float,
    val change: Float
)