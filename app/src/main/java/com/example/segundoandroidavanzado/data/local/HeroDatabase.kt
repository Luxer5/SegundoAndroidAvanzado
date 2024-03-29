package com.example.segundoandroidavanzado.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.segundoandroidavanzado.data.local.model.HeroLocal

@Database(entities = [HeroLocal::class], version = 1)
abstract class HeroDatabase : RoomDatabase(){
    abstract  fun superHeroDao(): HeroDao
}