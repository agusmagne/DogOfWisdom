package com.example.dogofwisdom.view.breed

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dogofwisdom.databinding.ActivityBreedBinding
import com.example.dogofwisdom.model.entities.Breed
import com.example.dogofwisdom.view.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedImagesActivity : BaseActivity() {
	
	companion object {
		const val BREED_DATA = "BREED_DATA"
	}
	
	private val viewModel: BreedViewModel by viewModels()
	private lateinit var binding: ActivityBreedBinding
	private lateinit var breedImagesRvAdapter: BreedImagesRvAdapter
	private lateinit var breed: Breed
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityBreedBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		breed = intent.getParcelableExtra(BREED_DATA)!!
		
		binding.breedName.text = breed.displayName
		binding.breedImagesRV.apply {
			breedImagesRvAdapter = BreedImagesRvAdapter()
			layoutManager = GridLayoutManager(this@BreedImagesActivity, 2)
			adapter = breedImagesRvAdapter
		}
		
		if (savedInstanceState == null) {
			viewModel.getImages(breed)
		}
		
		viewModel.imagesLD.observe(this) {
			breedImagesRvAdapter.updateImages(it)
		}
	}
}