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

    @Query("SELECT * FROM uzivatelData where id = 3")
    suspend fun getUzivatel1(): UzivatelData?

    @Query("SELECT * FROM uzivatelData WHERE id = (SELECT MAX(id) FROM uzivatelData)")
    suspend fun getUzivatelWithMaxId(): UzivatelData?

    @Query("DELETE FROM uzivatelData")
    suspend fun deleteAll()

    @Query("update uzivatelData set name = :newName where id = 1")
    suspend fun updateName(newName: String)

    @Query("update uzivatelData set pocetOtazok = :newPocetOtazok where id = 1")
    suspend fun updatePocetOtazok(newPocetOtazok: Int)

    @Query("update uzivatelData set pocetSpravnychOtazok = :newPocetSpravnychOtazok where id = 1")
    suspend fun updatePocetSpravnychOtazok(newPocetSpravnychOtazok: Int)

    @Query("update uzivatelData set celkovyCas = :newCelkovyCas where id = 1")
    suspend fun updateCelkovyCas(newCelkovyCas: Int)
}