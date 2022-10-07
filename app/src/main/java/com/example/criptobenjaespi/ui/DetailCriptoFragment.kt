package com.example.criptobenjaespi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.criptobenjaespi.R
import com.example.criptobenjaespi.databinding.FragmentDetailCriptoBinding

class DetailCriptoFragment : Fragment(R.layout.fragment_detail_cripto) {

    private lateinit var binding: FragmentDetailCriptoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailCriptoBinding.bind(view)
        val args by navArgs<DetailCriptoFragmentArgs>()

        binding.tvCriptoName.text = args.book
        binding.tvVolumeData.text = args.maximumAmount
        binding.tvHightData.text = args.maximumPrice
        binding.tvLowData.text = args.minimumPrice
        binding.tvLastData.text = args.maximumValue
    }

}