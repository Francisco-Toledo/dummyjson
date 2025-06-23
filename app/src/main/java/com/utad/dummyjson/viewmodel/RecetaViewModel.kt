package com.utad.dummyjson.viewmodel

import androidx.lifecycle.*
import com.utad.dummyjson.model.Receta
import com.utad.dummyjson.repository.RecetaRepository
import kotlinx.coroutines.launch

class RecetaViewModel {
    private val repository: RecetaRepository
    ) : ViewModel() {

        private val _recetas = MutableLiveData<List<Receta>>()
        val products: LiveData<List<Receta>> = _recetas

        private val _selectedReceta = MutableLiveData<Receta>()
        val selectedReceta: LiveData<Receta> = _selectedReceta

        // fun loadProducts(category: String) = viewModelScope.launch {
        //  _products.value = repository.getProductsByCategory(category)
        //}

        fun loadProductDetail(id: Int) = viewModelScope.launch {
            _selectedReceta.value = repository.getProductById(id)
        }

        fun loadProducts(difficulty: String) = viewModelScope.launch {
            try {
                val productos = repository.getProductsByDifficulty(difficulty)
                _recetas.value = productos
                // Log para verificar cuántos productos llegan
                android.util.Log.d("RecetaViewModel", "Recetas cargadas por dificultad '$difficulty': ${productos.size}")
            } catch (e: Exception) {
                android.util.Log.e("ProductViewModel", "Error cargando productos para categoría '$category'", e)
                _recetas.value = emptyList()
            }
        }


    }
}
