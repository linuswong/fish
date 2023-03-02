package com.example.apiproject

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiproject.databinding.ActivityFishListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FishListActivity: AppCompatActivity() {
    companion object {
        const val TAG = "FishListActivity"
        const val FISH = "red-snapper"
    }
    lateinit var adapter: FishAdapter
    lateinit var fish: List<FishData>

    private lateinit var binding: ActivityFishListBinding
    override fun onCreate(savedInstanceFish: Bundle?) {
        super.onCreate(savedInstanceFish)
        binding = ActivityFishListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getCountyDataByStateApiCall(FISH)
    }


    private fun getCountyDataByStateApiCall(fish: String) {
        var fishDataService =
            RetrofitHelper.getInstance().create(FishDataService::class.java)

        var fishDataCall=
            fishDataService.getFishDataByFish(fish)


        fishDataCall.enqueue(object: Callback<List<FishData>> {
            override fun onResponse(
                call: Call<List<FishData>>,
                response: Response<List<FishData>>
            ) {
                Log.d(TAG, "onRun: ${response.body()}")
                //the three lines to create the CountyAdapter

                if(response.body() != null) {
                    this@FishListActivity.fish = response.body()!!
                    adapter = FishAdapter(this@FishListActivity.fish)
                } else{
                    Log.d(TAG, "null")
                }
                binding.RecyclerViewFishList.adapter = adapter

                binding.RecyclerViewFishList.layoutManager = LinearLayoutManager(null)
            }



            override fun onFailure(call: Call<List<FishData>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        }
        )
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        var inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.fish_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection

//        if(response.body()!=null){
//            adapter=CountyAdapter(response.body()!!)
//        }
        adapter = FishAdapter(fish)
        binding.RecyclerViewFishList.adapter = adapter
        binding.RecyclerViewFishList.layoutManager = LinearLayoutManager(null)

        return when (item.itemId) {
            R.id.menu_fishMenu_sortBySpeciesName -> {
                fish=fish.sortedBy {
                    it.scientificName
                }
                true
            }
            R.id.menu_fishMenu_sortByPopulation -> {
                fish=fish.sortedBy {
                    it.Population
                }
                true
            }
            R.id.menu_fishMenu_sortByCarbs -> {
                fish =
                    fish.sortedWith(compareByDescending<FishData> { it.carbohydrates }
                        .thenByDescending { it.carbohydrates.toInt() })
                true
            }
//            R.id.menu_actualInfo -> {
//                val builder = AlertDialog.Builder(this)
//
//                with(builder)
//                {
//                    setTitle("Info")
//                    setMessage("Red: High Transmission\nOrange:Substantial Transmission\nYellow: " +
//                            "Moderate Transmission\nBlue: Low Transmission\n\nThe number represents " +
//                            "the weekly case count per 100k people in the county.")
//                    show()
//                }
//                true
//            }

            else -> super.onOptionsItemSelected(item)
            //I was here
        }

    }


}
