package com.kotlin.mvvm

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.kotlin.mvvm.databinding.ActivityMainBinding
import com.kotlin.mvvm.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })
        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }

    //Método para cambiar a horizontal
    private fun cambiarAHorizontal() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }
    //Método para cambiar a vertical
    private fun cambiarAVertical() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            cambiarAHorizontal()
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            cambiarAVertical()
        }
    }
}