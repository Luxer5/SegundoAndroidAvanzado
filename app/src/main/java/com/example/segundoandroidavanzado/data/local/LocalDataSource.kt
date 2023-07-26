package com.example.segundoandroidavanzado.data.local

import com.example.segundoandroidavanzado.data.local.model.HeroLocal
import com.example.segundoandroidavanzado.domain.model.HeroModel

interface LocalDataSource {
    suspend fun insertHeroList(heroList: List<HeroLocal>)
    suspend fun getHeroList() : List<HeroLocal>

    suspend fun getHeroById(id:String): HeroLocal

    suspend fun setFavorite(hero:HeroLocal)
}