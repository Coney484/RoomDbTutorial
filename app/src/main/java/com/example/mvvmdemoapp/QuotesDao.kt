package com.example.mvvmdemoapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuotesDao {

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Query("SELECT * FROM quote")
    fun getQuotes(): LiveData<List<Quote>>

}