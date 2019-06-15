package com.vshkl.coins.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coins(
    val data: Data,
    val status: String
)
