package com.example.apiproject

import android.widget.Adapter

class FishListActivity {
    companion object{
        const val TAG="FishListActivity"
        const val FISH="red-snapper"
    }
    lateinit var adapter: Adapter
    lateinit var counties: List<FishData>
}