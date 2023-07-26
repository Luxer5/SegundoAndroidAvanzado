package com.example.segundoandroidavanzado.data

import com.example.segundoandroidavanzado.domain.model.HeroModel
import com.example.segundoandroidavanzado.domain.model.LocationModel

interface HeroRepository {

    suspend fun getHeroList(): List<HeroModel>

    suspend fun getHeroById(id: String): HeroModel

    suspend fun setFavorite(hero: HeroModel)

    suspend fun getLocationList(id:String): List<LocationModel>
}