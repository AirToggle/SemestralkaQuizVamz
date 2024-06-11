package com.example.semestralka_quiz_geo.obrazovky.Encyklopedia

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NacitavanieObsahuView : ViewModel() {


    fun NacitajObsahy(context: Context): List<ObsahEncyklopedie> {
        try {
            val assetManager: AssetManager = context.assets
            val inputStream = assetManager.open("encyklopedia.json")
            val gson = Gson()
            val listObsahType = object : TypeToken<List<ObsahEncyklopedie>>() {}.type
            val listObsahov: List<ObsahEncyklopedie> = gson.fromJson(inputStream.reader(), listObsahType)
            for (obsah in listObsahov) {
                println("Title: ${obsah.title}")
                println("Susedia: ${obsah.susedia}")
            }
            inputStream.close()
            return listObsahov
        } catch (e: Exception) {
            Log.e("LoadTest", "Error reading test file: $e")
            return emptyList()
        }
    }
}