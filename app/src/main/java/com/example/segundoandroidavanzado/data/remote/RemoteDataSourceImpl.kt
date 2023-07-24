package com.example.segundoandroidavanzado.data.remote

import com.example.segundoandroidavanzado.data.dto.HeroDTO
import com.example.segundoandroidavanzado.data.dto.SearchDto

class RemoteDataSourceImpl(
    private val superHeroApi: SuperHeroApi
): RemoteDataSource {
    override suspend fun getHeroList(): List<HeroDTO> = superHeroApi.getHeroList(SearchDto())
}