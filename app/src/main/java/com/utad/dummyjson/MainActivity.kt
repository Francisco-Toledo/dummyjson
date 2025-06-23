package com.utad.dummyjson

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.utad.dummyjson.R

import com.utad.dummyjson.databinding.ActivityMainBinding
import com.utad.dummyjson.network.RetrofitClient
import com.utad.dummyjson.repository.RecetaRepository
import com.utad.dummyjson.view.RecetaAdapter
import com.utad.dummyjson.viewmodel.RecetaViewModel
import com.utad.dummyjson.viewmodel.RecetaViewModelFactory
import com.utad.dummyjson.view.DetailActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: RecetaViewModel by viewModels {
        RecetaViewModelFactory(RecetaRepository(RetrofitClient.api))
    }

    private lateinit var adapter: RecetaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)

        adapter = RecetaAdapter { receta ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("receta_id", receta.id)
            startActivity(intent)
        }

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        // Observadores

        viewModel.receta.observe(this) { receta ->
            Log.d("MainActivity", "Productos recibidos: ${receta.size}")
            adapter.submitList(receta)
        }


        // Categoría por defecto
        viewModel.loadProducts("difficulty")
    }

    // ---------- Menú ----------

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val category = when (item.itemId) {
            R.id.menu_receta    -> "easy"
            R.id.menu_receta       -> "medium"
            R.id.menu_mens_receta   -> "all difficults"
            else -> return super.onOptionsItemSelected(item)
        }
        Log.d("MainActivity", "Categoría seleccionada: $difficulty")  // <-- Aquí
        viewModel.loadProducts(category)
        return true

    }
}
