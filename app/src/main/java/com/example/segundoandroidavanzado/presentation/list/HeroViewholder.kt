package com.example.segundoandroidavanzado.presentation.list

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.segundoandroidavanzado.databinding.ItemHeroBinding
import com.example.segundoandroidavanzado.domain.model.HeroModel
import java.text.FieldPosition

class HeroViewholder(
    private val binding: ItemHeroBinding
) :RecyclerView.ViewHolder(binding.root ){

    fun bind(hero:HeroModel, onClick:(HeroModel) -> Unit){
        binding.tvName.text = hero.name

        Glide.with(binding.root.context)
            .load(hero.photoUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.imageView)

        binding.root.setOnClickListener {
            onClick(hero)
        }
    }

}