package com.example.semestralka_quiz_geo.Uzivatel

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UzivatelDao {

    @Insert
    suspend fun insert(uzivatel: UzivatelData)

    @Update
    suspend fun update(uzivatel: UzivatelData)

    @Query("SELECT * FROM uzivatelData LIMIT 1")
    suspend fun getUzivatel(): UzivatelData?

    @Query("SELECT * FROM uzivatelData where id = 0")
    suspend fun getUzivatel0(): UzivatelData?

    @Query("DELETE FROM uzivatelData")
    suspend fun deleteAll()
}