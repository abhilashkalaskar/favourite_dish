package com.abhilash.favouritedish.application

import android.app.Application
import com.abhilash.favouritedish.model.database.FavDishRepository
import com.abhilash.favouritedish.model.database.FavDishRoomDatabase

class FavDishApplication : Application() {

    private val database by lazy {
        FavDishRoomDatabase.getDatabase(this@FavDishApplication)
    }

    val repository by lazy {
        FavDishRepository(database.favDishDao())
    }

}