package com.example.segundoandroidavanzado.data.local

import com.example.segundoandroidavanzado.data.local.model.HeroLocal

class LocalDataSourceImpl(
    private val heroDao: HeroDao
): LocalDataSource {
    override suspend fun insertHeroList(heroList: List<HeroLocal>) {
        heroDao.insertAll(heroList)
    }

    override suspend fun getHeroList(): List<HeroLocal> = heroDao.getAll()
    override suspend fun getHeroById(id: String): HeroLocal =heroDao.getHeroById(id )
    override suspend fun setFavorite(hero: HeroLocal) = heroDao.setFavorite(hero)
}