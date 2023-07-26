package com.example.segundoandroidavanzado.data

import com.example.segundoandroidavanzado.domain.model.HeroModel

interface HeroRepository {

    suspend fun getHeroList(): List<HeroModel>

    suspend fun getHeroById(id: String): HeroModel

    suspend fun setFavorite(hero: HeroModel)
}