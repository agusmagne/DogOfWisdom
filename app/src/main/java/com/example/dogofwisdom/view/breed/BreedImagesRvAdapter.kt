package com.example.dogofwisdom.view.breed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dogofwisdom.databinding.BreedImagesRvSingleBinding

class BreedImagesRvAdapter : RecyclerView.Adapter<BreedImagesRvAdapter.BreedImagesViewHolder>() {
	
	private var images = listOf<String>()
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedImagesViewHolder {
		val view =
			BreedImagesRvSingleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return BreedImagesViewHolder(view)
	}
	
	override fun onBindViewHolder(holder: BreedImagesViewHolder, position: Int) {
		holder.bindView(images[position])
	}
	
	override fun getItemCount(): Int {
		return images.size
	}
	
	fun updateImages(newImages: List<String>) {
		images = listOf()
		images = newImages
		notifyItemRangeChanged(0, newImages.size - 1)
	}
	
	inner class BreedImagesViewHolder(val binding: BreedImagesRvSingleBinding) :
		RecyclerView.ViewHolder(binding.root) {
		fun bindView(imageUrl: String) {
			binding
			Glide.with(binding.root.context).load(imageUrl).into(binding.breedImage)
			
		}
	}
}