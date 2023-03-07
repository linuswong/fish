package com.example.apiproject

import android.os.Parcelable
import com.google.firebase.database.PropertyName
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FishData(
    @SerializedName("Fishery Management")
    val FisheryManagement: String?,
    val Habitat:String?,
//    @SerializedName("Image Gallery")
//    val imageGallery: ImageGallery?,
    val Location: String,
    @SerializedName("Scientific Name")
    var scientific_name:String?,
    @SerializedName("Species Aliases")
    val speciesAliases:String,
    @SerializedName("Species Name")
    val SpeciesName:String,
    val Population: String,
    val Calories:String,
    val Carbohydrate: String,
    val Cholesterol: String,
    val Fat: String,
    val Fiber:String,
    val Sugars: String
): Parcelable, Comparable<FishData> {
    override fun compareTo(other: FishData): Int {
        return this.Calories.toInt()
    }
    @Parcelize
    data class ImageGallery(
        val src:String?,
        val alt: String?
    ):Parcelable
}



