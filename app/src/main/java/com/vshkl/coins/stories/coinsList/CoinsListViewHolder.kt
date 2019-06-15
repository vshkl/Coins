package com.vshkl.coins.stories.coinsList

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_coin.view.*

class CoinsListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvRank: TextView = itemView.tvRank
    val ivIcon: ImageView = itemView.ivIcon
    val tvName: TextView = itemView.tvName
    val tvSymbol: TextView = itemView.tvSymbol
    val tvChange: TextView = itemView.tvChange
    val tvMarketCap: TextView = itemView.tvMarketCap
    val tvPrice: TextView = itemView.tvPrice
}
