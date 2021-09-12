package com.example.dogofwisdom.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogofwisdom.databinding.BreedsRvRowBinding
import com.example.dogofwisdom.model.entities.Breed

class BreedsRvAdapter(
	private val onClickEvent: (Breed) -> Unit
) : RecyclerView.Adapter<BreedsRvAdapter.BreedsViewHolder>() {
	
	private var breeds: List<Breed> = listOf()
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedsViewHolder {
		val view =
			BreedsRvRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return BreedsViewHolder(view)
	}
	
	override fun onBindViewHolder(holder: BreedsViewHolder, position: Int) {
		breeds[position].apply {
			holder.bindView(this)
			holder.itemView.setOnClickListener { onClickEvent(this) }
		}
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
	
	inner class BreedsViewHolder(private val binding: BreedsRvRowBinding) :
		RecyclerView.ViewHolder(binding.root) {
		fun bindView(breed: Breed) {
			binding.breedName.text = breed.displayName
		}
	}
}