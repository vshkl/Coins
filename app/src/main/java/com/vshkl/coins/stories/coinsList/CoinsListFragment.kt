package com.vshkl.coins.stories.coinsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vshkl.coins.R

class CoinsListFragment : Fragment() {

    private lateinit var rvCoins: RecyclerView
    private lateinit var coinsListAdapter: CoinsListAdapter
    private lateinit var viewModel: CoinsListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_coins_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvCoins = view.findViewById(R.id.rvCoins)
        initRecyclerView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CoinsListViewModel::class.java)
        viewModel.init()
        viewModel.getCoins().observe(this, Observer { coins ->
            coinsListAdapter.setCoins(coins.data.coins)
            coinsListAdapter.notifyDataSetChanged()
        })
    }

    private fun initRecyclerView() {
        coinsListAdapter = CoinsListAdapter(context!!)

        rvCoins.layoutManager = LinearLayoutManager(context)
        rvCoins.adapter = coinsListAdapter
    }

}
