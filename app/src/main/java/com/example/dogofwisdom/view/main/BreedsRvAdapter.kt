package com.example.dogofwisdom.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogofwisdom.databinding.BreedsRvRowBinding
import com.example.dogofwisdom.model.entities.Breed

class BreedsRvAdapter(private var breeds: List<Breed> = listOf()): RecyclerView.Adapter<BreedsRvAdapter.BreedsViewHolder>() {
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedsViewHolder {
		val itemView = BreedsRvRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return BreedsViewHolder(itemView)
	}
	
	override fun onBindViewHolder(holder: BreedsViewHolder, position: Int) {
		holder.bindView(breeds[position])
	}
	
	override fun getItemCount(): Int {
		return breeds.size
	}
	
	fun updateBreeds(newBreeds: List<Breed>) {
		val list = listOf<Breed>()
		breeds = list
		breeds = newBreeds
		notifyItemRangeChanged(0, newBreeds.size - 1)
	}
	
	inner class BreedsViewHolder(private val binding: BreedsRvRowBinding): RecyclerView.ViewHolder(binding.root) {
		fun bindView(breed: Breed) {
			binding.breedName.text = breed.name
		}
	}
}