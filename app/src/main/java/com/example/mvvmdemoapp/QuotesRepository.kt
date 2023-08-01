package com.example.mvvmdemoapp

import androidx.lifecycle.LiveData

class QuotesRepository(private val quotesDao: QuotesDao) {

    fun getQuotes(): LiveData<List<Quote>> {
        return quotesDao.getQuotes()
    }

    suspend fun insertQuote(quote: Quote) {
        quotesDao.insertQuote(quote)
    }
}