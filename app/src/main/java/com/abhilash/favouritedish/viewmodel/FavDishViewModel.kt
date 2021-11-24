package com.abhilash.favouritedish.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.abhilash.favouritedish.model.database.FavDishRepository
import com.abhilash.favouritedish.model.entities.FavDish
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class FavDishViewModel (private val repository: FavDishRepository) : ViewModel() {

    fun insert(dish: FavDish) = viewModelScope.launch {
        repository.insertFavDishData(dish)
    }
}

class FavDishViewModelFactory(private val favDishRepository: FavDishRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavDishViewModel::class.java)){
            @Suppress("UNCHECKED CAST")
            return FavDishViewModel(favDishRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}