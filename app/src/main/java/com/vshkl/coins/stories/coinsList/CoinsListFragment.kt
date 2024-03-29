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
import com.vshkl.coins.stories.EndlessScrollListener
import androidx.recyclerview.widget.DividerItemDecoration

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
        viewModel.getCoins().observe(viewLifecycleOwner, Observer { coins ->
            coinsListAdapter.setCoins(coins)
        })
    }

    private fun initRecyclerView() {
        coinsListAdapter = CoinsListAdapter(context!!)

        val linearLayoutManager = LinearLayoutManager(context)

        rvCoins.layoutManager = linearLayoutManager
        rvCoins.addItemDecoration(DividerItemDecoration(context!!, DividerItemDecoration.VERTICAL))
        rvCoins.addOnScrollListener(object : EndlessScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
//                viewModel.loadMoreCoins()
            }
        })
        rvCoins.adapter = coinsListAdapter
    }

}
