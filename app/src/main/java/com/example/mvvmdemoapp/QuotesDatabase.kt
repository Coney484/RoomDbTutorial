package com.example.mvvmdemoapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Quote::class], version = 1)
abstract class QuotesDatabase : RoomDatabase() {

    abstract fun quotesDao(): QuotesDao

    companion object {
        private var INSTANCE: QuotesDatabase? = null

        fun getDatabase(context: Context): QuotesDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, QuotesDatabase::class.java, "quotes_db")
                            .createFromAsset("quotes.db")
                            .build()
                }


            }
            return INSTANCE!!
        }
    }
}