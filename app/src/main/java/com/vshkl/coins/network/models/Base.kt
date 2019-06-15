package com.vshkl.coins.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Base(
    val sign: String,
    val symbol: String
)