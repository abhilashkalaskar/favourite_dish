package com.abhilash.favouritedish.model.database

import androidx.room.Dao
import androidx.room.Insert
import com.abhilash.favouritedish.model.entities.FavDish

@Dao
interface FavDishDao {

    @Insert
    suspend fun insertFavouriteDishDetails(favDish: FavDish)

}