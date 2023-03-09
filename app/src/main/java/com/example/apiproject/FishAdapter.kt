package com.example.apiproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class FishAdapter(private val dataSet: List<FishData>): RecyclerView.Adapter<FishAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewHabitat: TextView
        val textViewLastSpeciesName: TextView
        var imageViewFishImage: ImageView
        val layout: ConstraintLayout

        init {
            textViewHabitat = view.findViewById(R.id.textView_fishData_population)
            textViewLastSpeciesName = view.findViewById(R.id.textView_fishData_speciesName)
            imageViewFishImage = view.findViewById(R.id.imageView_fishData_fishImage)
            layout = view.findViewById(R.id.layout_fishData)


        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_fish_data, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        var context = viewHolder.imageViewFishImage.context
        val fish = dataSet[position]
        viewHolder.textViewLastSpeciesName.text = fish.SpeciesName
        viewHolder.textViewHabitat.text = fish.Habitat
        Picasso.get().load(fish.imageGallery!!.src).into(viewHolder.imageViewFishImage)
        viewHolder.layout.setOnClickListener {
            Toast.makeText(it.context,"$context", Toast.LENGTH_SHORT).show()
            val detailIntent = Intent(it.context, FishDetailActivity::class.java)
            detailIntent.putExtra(FishDetailActivity.EXTRA_FISH, fish)
            it.context.startActivity(detailIntent)
        }

    }


    override fun getItemCount() = dataSet.size

}