package com.vshkl.coins.stories.coinsList

import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.vshkl.coins.R
import com.vshkl.coins.network.models.Coin
import com.vshkl.coins.utils.svg.SvgSoftwareLayerSetter

class CoinsListAdapter(context: Context) : RecyclerView.Adapter<CoinsListViewHolder>() {

    private val coins: MutableList<Coin> = mutableListOf()
    private var glideRequestBuilder: RequestBuilder<PictureDrawable> = Glide
        .with(context)
        .`as`(PictureDrawable::class.java)
        .listener(SvgSoftwareLayerSetter())

    override fun getItemCount(): Int =
        coins.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsListViewHolder =
        CoinsListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false))

    override fun onBindViewHolder(holder: CoinsListViewHolder, position: Int) {
        with(coins[position]) {
            holder.tvRank.text = rank.toString()
            holder.tvName.text = name
            holder.tvSymbol.text = symbol
            holder.tvChange.text = change.toString()
            holder.tvMarketCap.text = marketCap.toString()
            holder.tvPrice.text = price

            glideRequestBuilder
                .load(Uri.parse(iconUrl))
                .into(holder.ivIcon)
        }
    }

    fun setCoins(coins: List<Coin>) {
        this.coins.addAll(coins)
        notifyDataSetChanged()
    }

}