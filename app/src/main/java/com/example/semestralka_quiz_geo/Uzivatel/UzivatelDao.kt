package com.example.semestralka_quiz_geo.Uzivatel

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UzivatelDao {

    @Insert
    suspend fun insert(uzivatel: UzivatelData)

    @Query("SELECT * FROM uzivatelData LIMIT 1")
    suspend fun getUzivatel(): UzivatelData?

    @Query("DELETE FROM uzivatelData")
    suspend fun deleteAll()
}