package com.example.semestralka_quiz_geo.Uzivatel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UzivatelData::class], version = 1, exportSchema = false)
abstract class UzivatelDB : RoomDatabase() {
//nieco mi tu svietilo s internal errorm
    abstract fun uzivatelDao(): UzivatelDao

    companion object {
        @Volatile
        private var INSTANCE: UzivatelDB? = null

        fun getInstance(context: Context): UzivatelDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UzivatelDB::class.java,
                    "uzivatelData"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
