package com.abhilash.favouritedish.model.database

import androidx.annotation.WorkerThread
import com.abhilash.favouritedish.model.entities.FavDish
import kotlinx.coroutines.flow.Flow

class FavDishRepository (private val favDishDao: FavDishDao) {

    @WorkerThread
    suspend fun insertFavDishData (favDish: FavDish) {
        favDishDao.insertFavouriteDishDetails(favDish)
    }

    val allDishesList: Flow<List<FavDish>> = favDishDao.getAllDishesList()
}