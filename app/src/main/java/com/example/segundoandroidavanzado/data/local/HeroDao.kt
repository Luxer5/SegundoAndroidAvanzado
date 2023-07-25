package com.example.segundoandroidavanzado.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.segundoandroidavanzado.data.local.model.HeroLocal

@Dao
interface HeroDao {

    @Query("SELECT * FROM SuperHeroTable")
    suspend fun getAll(): List<HeroLocal>

    @Query("SELECT * FROM SuperHeroTable WHERE id=:id")
    suspend fun getHeroById(id:String): HeroLocal


    @Query("SELECT * FROM SuperHeroTable")
    suspend fun getFavorites(): List<HeroLocal>

    //Insertar los datos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<HeroLocal>)
    //suspend fun insertAll(vararg  superHero: HeroLocal)

    @Delete
    suspend fun delete(model: HeroLocal)
}