package com.example.mvvmdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: QuotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = QuotesDatabase.getDatabase(applicationContext).quotesDao()
        val repo = QuotesRepository(dao)
        viewModel =
            ViewModelProvider(this, MainViewModelFactory(repo)).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this) {
            binding.quotes = it.toString()
            Log.d("Rohan", it.toString())
        }

        binding.btnAddQuote.setOnClickListener {
            val quote = Quote(0, "This is Testing", "Rohan Choudhary")
            viewModel.insertQuotes(quote)
        }


    }
}