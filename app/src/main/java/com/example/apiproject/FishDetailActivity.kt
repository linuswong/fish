package com.example.apiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apiproject.databinding.ActivityFishDetailBinding

class FishDetailActivity : AppCompatActivity() {
    companion object{
        val EXTRA_FISH="Fish"
    }
    private lateinit var binding: ActivityFishDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFishDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}