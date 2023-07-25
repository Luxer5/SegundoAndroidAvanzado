package com.example.segundoandroidavanzado.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.segundoandroidavanzado.databinding.ItemHeroBinding
import com.example.segundoandroidavanzado.domain.model.HeroModel

class ListAdapter(
    private var list: List<HeroModel> = listOf(),
    private var onclick: (HeroModel) -> Unit
    ): RecyclerView.Adapter<HeroViewholder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewholder {
        return HeroViewholder(
            ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HeroViewholder, position: Int) {
        holder.bind(list[position], onclick)

    }
}