package com.example.dogofwisdom.view.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogofwisdom.databinding.ActivityMainBinding
import com.example.dogofwisdom.view.BaseActivity
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
        
        viewModel.getBreeds()
		
		binding.breedsRV.apply {
			breedsRvAdapter = BreedsRvAdapter()
			layoutManager = LinearLayoutManager(this@MainActivity)
			adapter = breedsRvAdapter
		}
		
		viewModel.breedsLD.observe(this) {
			breedsRvAdapter.updateBreeds(it)
		}
	}
}