package com.utad.dummyjson.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.utad.dummyjson.repository.RecetaRepository

class RecetaViewModelFactory {
    private val repository: RecetaRepository
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            when {
                modelClass.isAssignableFrom(RecetaViewModel::class.java) ->
                    RecetaViewModel(repository) as T
                else -> throw IllegalArgumentException("Unknown ViewModel class")
            }
    }
