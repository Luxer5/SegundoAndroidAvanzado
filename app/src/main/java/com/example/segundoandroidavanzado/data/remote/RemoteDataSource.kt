package com.example.segundoandroidavanzado.data.remote

import com.example.segundoandroidavanzado.data.dto.HeroDTO

interface RemoteDataSource {
    suspend fun getHeroList(): List<HeroDTO>
}
