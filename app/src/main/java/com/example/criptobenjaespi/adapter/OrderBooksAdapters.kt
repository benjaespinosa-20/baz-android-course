package com.example.criptobenjaespi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.criptobenjaespi.R
import com.example.criptobenjaespi.core.BaseViewHolder
import com.example.criptobenjaespi.data.repository.model.CriptoList
import com.example.criptobenjaespi.data.repository.model.AsksBidsModel
import com.example.criptobenjaespi.databinding.ListItemBinding
import com.example.criptobenjaespi.databinding.ListorderbookItemBinding

class OrderBooksAdapters (): RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var orderBooks: List<AsksBidsModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ListorderbookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = OrderBooksViewHolder(itemBinding)
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder){
            is OrderBooksViewHolder -> holder.bind(orderBooks[position])
        }
    }

    override fun getItemCount(): Int = orderBooks.size

    private inner class OrderBooksViewHolder(val binding: ListorderbookItemBinding): BaseViewHolder<AsksBidsModel>(binding.root){
        override fun bind(item: AsksBidsModel) {
            binding.tvOrderBook.text = "Name: ${item.book} Amount:${item.amount} Price:${item.price}"
            
        }

    }

    fun setList(asksBidsModel: List<AsksBidsModel>){
        orderBooks = asksBidsModel
        notifyDataSetChanged()
    }
}