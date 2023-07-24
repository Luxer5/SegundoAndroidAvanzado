package com.example.segundoandroidavanzado.data

import com.example.segundoandroidavanzado.data.remote.RemoteDataSource
import com.example.segundoandroidavanzado.domain.model.HeroModel
import toHeroModel

class HeroRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): HeroRepository {

    /*private fun mockList() = listOf(
        HeroModel("Vegeta"),
        HeroModel("Goku"),
        HeroModel("Picolo"),
        HeroModel("Frieza"))*/

    override suspend fun getHeroList() = remoteDataSource.getHeroList().map {
        it.toHeroModel()
    }
}