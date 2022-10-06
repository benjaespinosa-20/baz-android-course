package com.example.criptobenjaespi.ui.criptolist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.criptobenjaespi.R
import com.example.criptobenjaespi.adapter.CriptoAdapter
import com.example.criptobenjaespi.core.Resource
import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.data.model.Payload
import com.example.criptobenjaespi.databinding.FragmentCriptoBinding
import com.example.criptobenjaespi.presentation.CriptoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CriptoFragment : Fragment(R.layout.fragment_cripto), CriptoAdapter.OnCriptoClickListener {

    private lateinit var binding: FragmentCriptoBinding
    private val viewModel: CriptoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCriptoBinding.bind(view)

        viewModel.fetchCriptoList().observe(viewLifecycleOwner, Observer { listCripto ->
            when (listCripto){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Succes -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvCriptos.adapter = CriptoAdapter(listCripto.data.payload, this@CriptoFragment)

                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        })
    }

    override fun onCriptoClick(cripto: Payload) {
        val action = CriptoFragmentDirections.actionCriptoFragmentToDetailCriptoFragment(
            cripto.book,
            cripto.maximum_amount,
            cripto.maximum_price,
            cripto.minimum_price,
            cripto.maximum_value
        )
        findNavController().navigate(action)
    }

}