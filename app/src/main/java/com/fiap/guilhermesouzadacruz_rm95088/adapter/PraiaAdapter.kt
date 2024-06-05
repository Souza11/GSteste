package com.fiap.guilhermesouzadacruz_rm95088.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fiap.guilhermesouzadacruz_rm95088.databinding.ItemBinding
import com.fiap.guilhermesouzadacruz_rm95088.model.Praia

class PraiaAdapter(private val items: List<Praia>) : RecyclerView.Adapter<PraiaAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Praia) {
            binding.textViewName.text = item.nome
            binding.textViewCity.text = item.cidade
            binding.textViewState.text = item.estado
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
