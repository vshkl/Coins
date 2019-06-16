package com.vshkl.coins.stories.models

import com.vshkl.coins.network.models.Coin as NetworkCoin

object Mappers {

    fun mapCoins(coins: List<NetworkCoin>): List<Coin> = coins.map(this::mapCoin)

    private fun mapCoin(coin: NetworkCoin): Coin = Coin(
        rank = coin.rank.toString(),
        name = coin.name.toString(),
        symbol = coin.symbol.toString(),
        iconUrl = coin.iconUrl.toString(),
        price = formatPrice(coin.price),
        change = formatChange(coin.change),
        marketCap = formatMarketCap(coin.marketCap)
    )

    private fun formatPrice(price: String?): String = when {
        price != null -> {
            val priceNum = price.toDouble()
            when {
                priceNum < 0.1 -> "$%.3f".format(priceNum)
                priceNum < 0.01 -> "$%.4f".format(priceNum)
                priceNum < 0.001 -> "$%.5f".format(priceNum)
                priceNum < 0.0001 -> "$%.6f".format(priceNum)
                priceNum < 0.00001 -> "$%.7f".format(priceNum)
                else -> "$%.2f".format(priceNum)
            }
        }
        else -> ""
    }

    private fun formatChange(change: Double?): String = when {
        change != null ->
            when {
                change > 0 -> "${"+%.2f".format(change)}%"
                change < 0 -> "${"%.2f".format(change)}%"
                else -> "0%"
            }
        else -> ""
    }

    private fun formatMarketCap(marketCap: Long?): String = when {
        marketCap != null -> {
            when {
                marketCap > 999999999 -> "$${marketCap / 1000000000} B"
                marketCap > 999999 -> "$${marketCap / 1000000} B"
                marketCap > 99999 -> "$${marketCap / 1000} B"
                else ->"$$marketCap"
            }
        }
        else -> ""
    }

}