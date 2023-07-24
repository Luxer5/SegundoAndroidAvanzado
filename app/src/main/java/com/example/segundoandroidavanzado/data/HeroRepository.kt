package com.example.segundoandroidavanzado.data

import com.example.segundoandroidavanzado.domain.model.HeroModel

interface HeroRepository {

    suspend fun getHeroList(): List<HeroModel>
}