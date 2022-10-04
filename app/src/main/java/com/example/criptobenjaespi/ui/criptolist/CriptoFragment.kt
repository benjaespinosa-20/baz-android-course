package com.example.criptobenjaespi.ui.criptolist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.criptobenjaespi.R
import com.example.criptobenjaespi.core.Resource
import com.example.criptobenjaespi.databinding.FragmentCriptoBinding
import com.example.criptobenjaespi.presentation.CriptoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CriptoFragment : Fragment(R.layout.fragment_cripto) {

    private lateinit var binding: FragmentCriptoBinding
    private val viewModel: CriptoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCriptoBinding.bind(view)

        viewModel.fetchCriptoList().observe(viewLifecycleOwner, Observer { listCripto ->
            when (listCripto){
                is Resource.Loading -> {
                    //binding.progressBar.visibility = View.VISIBLE
                    Log.d("LiveData", "Loading")
                }
                is Resource.Succes -> {
                    //binding.rvCriptos.visibility = View.GONE
                    Log.d("LiveData", "${listCripto.data.toString()}")
                }
                is Resource.Failure -> {
                    //binding.progressBar.visibility = View.VISIBLE
                    Log.d("LiveData", "${listCripto.exception}")
                }
            }
        })
    }

}