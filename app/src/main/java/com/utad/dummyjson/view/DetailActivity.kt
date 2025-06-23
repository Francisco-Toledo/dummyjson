package com.utad.dummyjson.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.utad.dummyjson.network.RetrofitClient
import com.utad.dummyjson.repository.RecetaRepository
import com.utad.dummyjson.viewmodel.RecetaViewModel
import com.utad.dummyjson.viewmodel.RecetaViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: RecetaViewModel by viewModels {
        RecetaViewModelFactory(RecetaRepository(RetrofitClient.api))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("product_id", -1)
        viewModel.loadProductDetail(id)

        viewModel.selectedProduct.observe(this) {
            binding.title.text = it.title
            binding.price.text = "$${it.price}"
            binding.description.text = it.description
            Glide.with(this).load(it.image).into(binding.image)
        }
    }
}