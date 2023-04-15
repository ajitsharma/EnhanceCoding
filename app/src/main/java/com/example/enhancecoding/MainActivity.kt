package com.example.enhancecoding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.enhancecoding.databinding.ActivityMainBinding
import com.example.enhancecoding.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnSearch.setOnClickListener {
            searchQuery()
        }

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.singleSearchLiveData.observe(this, Observer {
            it?.let {
                binding.txtName.text = it.name?:"NA"
                binding.txtPremiered.text = it.premiered?:"NA"
                it.image?.let { image ->
                    Glide.with(this)
                        .load(image.original)
                        .into(binding.imgPoster)
                }
            }
        })
    }

    private fun searchQuery() {
        mainViewModel.getSingleSearchData(binding.etSearch.text.toString())
    }
}