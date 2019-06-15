package com.vshkl.coins.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coin(
    val change: Double?,
    val description: String?,
    val iconType: String?,
    val iconUrl: String?,
    val id: Int?,
    val marketCap: Long?,
    val name: String?,
    val price: String?,
    val rank: Int?,
    val symbol: String?,
    val volume: Long?,
    val websiteUrl: String?
)