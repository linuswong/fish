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

class FishAdapter(private val dataSet: List<FishData>):    RecyclerView.Adapter<FishAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewPopulation: TextView
        val textViewLastSpeciesName: TextView
        val imageViewFishImage: ImageView
        val layout: ConstraintLayout

        init {
            textViewPopulation = view.findViewById(R.id.textView_fishData_population)
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
        var context = viewHolder.textViewLastSpeciesName.context
        val fish = dataSet[position]
        viewHolder.textViewLastSpeciesName.text = fish.speciesName
        viewHolder.textViewPopulation.text = fish.population
        viewHolder.layout.setOnClickListener {
//            Toast.makeText(it.context, f, Toast.LENGTH_SHORT).show()
            val detailIntent = Intent(it.context, FishDetailActivity::class.java)
            detailIntent.putExtra(FishDetailActivity.EXTRA_FISH, fish)
            it.context.startActivity(detailIntent)
        }

    }
}