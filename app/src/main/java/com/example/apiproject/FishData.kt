package com.example.apiproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FishData(
    val fisheryManagement: String,
    val habitat:String,
    val imageGallery: ImageGallery,
    val location: String,
    val scientificName:String,
    val speciesAliases:String,
    val speciesName:String,

    val calories:String
): Parcelable, Comparable<FishData> {
    override fun compareTo(other: FishData): Int {
        return this.calories.toInt()
    }
}



@Parcelize
data class ImageGallery(
    val src:String?,
    val alt: String?
):Parcelable