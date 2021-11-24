package com.abhilash.favouritedish.model.database

import androidx.annotation.WorkerThread
import com.abhilash.favouritedish.model.entities.FavDish

class FavDishRepository (private val favDishDao: FavDishDao) {

    @WorkerThread
    suspend fun insertFavDishData (favDish: FavDish) {
        favDishDao.insertFavouriteDishDetails(favDish)
    }
}