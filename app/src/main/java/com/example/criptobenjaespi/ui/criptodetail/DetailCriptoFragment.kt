package com.example.criptobenjaespi.ui.criptodetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.criptobenjaespi.R
import com.example.criptobenjaespi.adapter.CriptoAdapter
import com.example.criptobenjaespi.core.Resource
import com.example.criptobenjaespi.databinding.FragmentDetailCriptoBinding
import com.example.criptobenjaespi.presentation.CriptoTickerViewModel
import com.example.criptobenjaespi.presentation.CriptoViewModel

class DetailCriptoFragment : Fragment(R.layout.fragment_detail_cripto) {

    private lateinit var binding: FragmentDetailCriptoBinding
    private val args by navArgs<DetailCriptoFragmentArgs>()
    private val viewModel: CriptoTickerViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailCriptoBinding.bind(view)

        binding.tvCriptoName.text = args.book
        binding.tvVolumeData.text = args.maximumAmount
        binding.tvHightData.text = args.maximumPrice
        binding.tvLowData.text = args.minimumPrice
        binding.tvLastData.text = args.maximumValue



        /*viewModel.fetchCriptoTicker(bookName).observe(viewLifecycleOwner, Observer { ticker ->
            when (ticker){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Succes -> {

                    binding.progressBar.visibility = View.GONE
                    binding.tvCriptoName.text = ticker.data.book
                    binding.tvHightData.text = ticker.data.hight
                    binding.tvLastData.text = ticker.data.last
                    binding.tvLowData.text = ticker.data.low
                    binding.tvVolumeData.text = ticker.data.volume
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        })*/
    }

}