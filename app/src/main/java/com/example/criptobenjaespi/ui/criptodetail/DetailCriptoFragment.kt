package com.example.criptobenjaespi.ui.criptodetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.criptobenjaespi.R
import com.example.criptobenjaespi.adapter.OrderBooksAdapters
import com.example.criptobenjaespi.core.Resource
import com.example.criptobenjaespi.databinding.FragmentDetailCriptoBinding
import com.example.criptobenjaespi.presentation.CriptoTickerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailCriptoFragment : Fragment(R.layout.fragment_detail_cripto) {

    private lateinit var binding: FragmentDetailCriptoBinding
    private val args by navArgs<DetailCriptoFragmentArgs>()
    private val viewModel: CriptoTickerViewModel by viewModels()
    private val adapter = OrderBooksAdapters()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailCriptoBinding.bind(view)
        binding.rvOrderBooks.adapter = adapter
        binding.rvOrderBooks.layoutManager =
            LinearLayoutManager(binding.root.context, RecyclerView.VERTICAL, false)

        viewModel.fetchCriptoTicker(args.book).observe(viewLifecycleOwner) { tickerResponse ->
            when (tickerResponse) {
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Succes -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvCriptoName.text = tickerResponse.data.book
                    binding.tvVolumeData.text = tickerResponse.data.volume
                    binding.tvHightData.text = tickerResponse.data.hight
                    binding.tvLowData.text = tickerResponse.data.low
                    binding.tvLastData.text = tickerResponse.data.last
                }
            }

        }

        viewModel.fetchOrderBook(args.book).observe(viewLifecycleOwner) { tickerResponse ->
            when (tickerResponse) {
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Succes -> {
                    adapter.setList(tickerResponse.data.asks)
                    binding.progressBar.visibility = View.GONE
                }
            }

        }

        binding.btnBids.setOnClickListener {
            adapter.setList(viewModel.orderBooksModel?.bids ?: emptyList())
        }

        binding.btnAsk.setOnClickListener {
            adapter.setList(viewModel.orderBooksModel?.asks ?: emptyList())
        }

    }

}