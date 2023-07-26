package com.example.segundoandroidavanzado.data.remote

import LocationDto
import com.example.segundoandroidavanzado.data.dto.HeroDTO

interface RemoteDataSource {
    suspend fun getHeroList(): List<HeroDTO>

    suspend fun getLocationList(id: String): List<LocationDto>
}
