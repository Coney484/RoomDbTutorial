package com.example.mvvmdemoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuotesViewModel(private val repository: QuotesRepository) : ViewModel() {

    fun getQuotes(): LiveData<List<Quote>> {
        return repository.getQuotes()
    }

    fun insertQuotes(quote: Quote) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertQuote(quote)
        }

    }
}