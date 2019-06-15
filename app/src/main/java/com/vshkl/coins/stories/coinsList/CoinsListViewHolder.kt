package com.vshkl.coins.stories.coinsList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_coin.view.*

class CoinsListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvRank = itemView.tvRank
    val ivIcon = itemView.ivIcon
    val tvName = itemView.tvName
    val tvPrice = itemView.tvPrice
}
