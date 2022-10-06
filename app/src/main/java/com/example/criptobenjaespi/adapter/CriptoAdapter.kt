package com.example.criptobenjaespi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.criptobenjaespi.R
import com.example.criptobenjaespi.core.BaseViewHolder
import com.example.criptobenjaespi.data.model.CriptoList
import com.example.criptobenjaespi.data.model.Payload
import com.example.criptobenjaespi.databinding.ListItemBinding

class CriptoAdapter(
    private val criptoList: List<Payload>,
    private val itemClickListener: OnCriptoClickListener
    ): RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnCriptoClickListener{
        fun onCriptoClick(cripto: Payload)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = CriptoViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener{
            val position = holder.bindingAdapterPosition.takeIf { it!= DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener
            itemClickListener.onCriptoClick(criptoList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder){
            is CriptoViewHolder -> holder.bind(criptoList[position])
        }
    }

    override fun getItemCount(): Int = criptoList.size

    private inner class CriptoViewHolder(val binding: ListItemBinding, val context: Context): BaseViewHolder<Payload>(binding.root){
        override fun bind(item: Payload) {
            binding.tvCriptoName.text = item.book
            //val image = item.book

            val imageBook:Int = when(item.book){
                "bat_mxn" -> R.drawable.bat_mxn
                "bch_mxn" -> R.drawable.bch_mxn
                "btc_mxn" -> R.drawable.btc_mxn
                "dai_mxn" -> R.drawable.dai_mxn
                "eth_mxn" -> R.drawable.eth_mxn
                "ltc_mxn" -> R.drawable.ltc_mxn
                "mana_mxn" -> R.drawable.mana_mxn
                "tusd_mxn" -> R.drawable.tusd_mxn
                "usd_mxn" -> R.drawable.usd_mxn
                "xrp_mxn" -> R.drawable.xrp_mxn
                else -> {
                    item.book.toInt()
                }
            }

            binding.ivCripto.setImageResource(imageBook)
        }

    }
}