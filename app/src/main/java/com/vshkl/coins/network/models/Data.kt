package com.vshkl.coins.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    val base: Base,
    val coins: List<Coin>,
    val stats: Stats
)