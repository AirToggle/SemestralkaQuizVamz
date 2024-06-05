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
    @ColumnInfo(name = "name") var name: String = "Užívateľ",
    @ColumnInfo(name = "pocetOtazok") var pocetOtazok: Int = 0,
    @ColumnInfo(name = "pocetSpravnychOtazok") var pocetSpravnychOtazok: Int = 0,
    @ColumnInfo(name = "celkovyCas") var celkovyCas: Int = 0
) {
    // Metóda na uloženie údajov do databázy
    suspend fun ulozitUdaje(context: Context) {
        // Tu by ste použili metódu na prístup k databáze pomocou Room
        UzivatelDB.getInstance(context).uzivatelDao().insert(this)
    }

    // Metóda na načítanie údajov z databázy
    companion object {
        suspend fun nacitatUdaje(context: Context): UzivatelData? {
            // Tu by ste použili metódu na prístup k databáze pomocou Room
            return UzivatelDB.getInstance(context).uzivatelDao().getUzivatel()
            // Tento riadok je tu len ako ukážka, treba ho nahradiť príslušným kódom pre načítanie údajov z databázy
        }
    }

    // Metóda na vymazanie údajov z databázy
    suspend fun vymazatUdaje(context: Context) {
        // Tu by ste použili metódu na prístup k databáze pomocou Room
        UzivatelDB.getInstance(context).uzivatelDao().deleteAll()
    }

    // Metóda na zmenu mena
    suspend fun zmenitMeno(noveMeno: String, context: Context) {
        this.name = noveMeno
        ulozitUdaje(context)
    }

    // Metóda na pridanie počtu otázok
    suspend fun pridajPocetOtazok(context: Context) {
        this.pocetOtazok++
        ulozitUdaje(context)
    }

    // Metóda na pridanie počtu správnych otázok
    suspend fun pridajPocetSpravnychOtazok(context: Context) {
        this.pocetSpravnychOtazok++
        ulozitUdaje(context)
    }

    // Metóda na pridanie celkového času
    suspend fun pridajCelkovyCas(context: Context) {
        this.celkovyCas++
        ulozitUdaje(context)
    }
}
