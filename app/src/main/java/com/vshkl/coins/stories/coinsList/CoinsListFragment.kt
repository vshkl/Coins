package com.vshkl.coins.stories.coinsList

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.vshkl.coins.R

class CoinsListFragment : Fragment() {

    companion object {
        fun newInstance() = CoinsListFragment()
    }

    private lateinit var viewModel: CoinsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coins_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CoinsListViewModel::class.java)
        viewModel.init()
        viewModel.getCoins().observe(this, Observer { coins -> println(coins) })
    }

}
