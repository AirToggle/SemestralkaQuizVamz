package com.example.semestralka_quiz_geo.Uzivatel

import android.content.Context
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Entity(tableName = "uzivatelData")
@Serializable
data class UzivatelData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // Primárny kľúč pre databázový záznam
    @ColumnInfo(name = "name") var name: String = "Užívatel",
    @ColumnInfo(name = "pocetOtazok") var pocetOtazok: Int = 0,
    @ColumnInfo(name = "pocetSpravnychOtazok") var pocetSpravnychOtazok: Int = 0,
    @ColumnInfo(name = "celkovyCas") var celkovyCas: Int = 0
) {

    suspend fun ulozitUdaje(context: Context) {

        UzivatelDB.getInstance(context).uzivatelDao().insert(this)
    }

    suspend fun aktualizovatUdaje(context: Context) {
        val uzivatelDao = UzivatelDB.getInstance(context).uzivatelDao()
        uzivatelDao.update(this)
    }


    companion object {
        suspend fun nacitatUdaje(context: Context): UzivatelData? {

            return UzivatelDB.getInstance(context).uzivatelDao().getUzivatel0()

        }
    }

    suspend fun vymazatUdaje(context: Context) {
        UzivatelDB.getInstance(context).uzivatelDao().deleteAll()
    }

    suspend fun resetovatUdaje(context: Context) {
        this.name = "Uživatel"
        this.pocetOtazok = 0
        this.pocetSpravnychOtazok = 0
        this.celkovyCas = 0
        aktualizovatUdaje(context)
    }


    suspend fun zmenitMeno(noveMeno: String, context: Context) {
        this.name = noveMeno
        aktualizovatUdaje(context)
    }


    suspend fun pridajPocetOtazok(context: Context) {
        this.pocetOtazok++
    }


    suspend fun pridajPocetSpravnychOtazok(context: Context) {
        this.pocetSpravnychOtazok++
        this.pocetOtazok++
    }


    suspend fun pridajCelkovyCas(context: Context) {
        this.celkovyCas++
    }
}
