package com.example.dogofwisdom.view.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogofwisdom.databinding.ActivityMainBinding
import com.example.dogofwisdom.model.entities.Breed
import com.example.dogofwisdom.view.BaseActivity
import com.example.dogofwisdom.view.breed.BreedImagesActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
	
	private val viewModel: MainViewModel by viewModels()
	private lateinit var binding: ActivityMainBinding
	private lateinit var breedsRvAdapter: BreedsRvAdapter
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		if (savedInstanceState == null) {
			viewModel.getBreeds()
		}
		
		binding.breedsRV.apply {
			breedsRvAdapter = BreedsRvAdapter { onBreedClick(it) }
			layoutManager = LinearLayoutManager(this@MainActivity)
			adapter = breedsRvAdapter
		}
		
		viewModel.breedsLD.observe(this) {
			breedsRvAdapter.updateBreeds(it)
		}
	}
	
	private fun onBreedClick(breed: Breed) {
		Intent(this, BreedImagesActivity::class.java).apply {
			this.putExtra(BreedImagesActivity.BREED_DATA, breed)
			startActivity(this)
		}
		
	}
}