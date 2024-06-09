package com.example.semestralka_quiz_geo.Otazka

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NacitavanieOtazok : ViewModel() {

}

fun NacitajOtazky(context: Context): Test? {
    try {
        val assetManager: AssetManager = context.assets
        val inputStream = assetManager.open("otazky.json")
        val gson = Gson()
        val listQuestionType = object : TypeToken<List<Otazka>>() {}.type
        val questions: List<Otazka> = gson.fromJson(inputStream.reader(), listQuestionType)
        for (question in questions) {
            println("Question: ${question.question}")
            println("Answer: ${question.answer}")
        }
        inputStream.close()
        return null
    } catch(e: Exception) {
        Log.e("LoadTest", "Error reading test file: $e")
        return null
    }
}
