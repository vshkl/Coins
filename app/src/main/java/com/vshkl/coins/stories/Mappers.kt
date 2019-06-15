package com.vshkl.coins.stories

import com.vshkl.coins.stories.models.Coin
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

    private fun formatPrice(price: String?): String = "$%.2f".format(price?.toDouble())

    private fun formatChange(change: Double?): String = when {
        change != null ->
            when {
                change > 0 -> "${"+%.2f".format(change)}%"
                change < 0 -> "${"%.2f".format(change)}%"
                else -> "0%"
            }
        else -> ""
    }

    private fun formatMarketCap(marketCap: Long?): String {
        return when {
            marketCap != null -> "MCap $$marketCap"
            else -> ""
        }
    }

}