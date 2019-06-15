package com.vshkl.coins.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stats(
    val base: String,
    val limit: Int,
    val offset: Int,
    val order: String,
    val total: Int,
    val total24hVolume: Double,
    val totalExchanges: Int,
    val totalMarketCap: Double,
    val totalMarkets: Int
)