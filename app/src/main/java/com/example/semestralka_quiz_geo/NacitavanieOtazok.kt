package com.example.semestralka_quiz_geo

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.semestralka_quiz_geo.ui.theme.Test
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NacitavanieOtazok : ViewModel() {

}

fun NacitajOtazky(context: Context): Test? {
    // do something
    try {
        val assetManager: AssetManager = context.assets
        val inputStream = assetManager.open("otazky.json")

        val gson = Gson()
        val listQuestionType = object : TypeToken<List<Otazka>>() {}.type
        val questions: List<Otazka> = gson.fromJson(inputStream.reader(), listQuestionType)

        // Iterate through the questions
        for (question in questions) {
            println("Question: ${question.question}")
            println("Answer: ${question.answer}")
            // Process other fields as needed
        }

        // Close the input stream
        inputStream.close()
        return null
    } catch(e: Exception) {
        Log.e("LoadTest", "Error reading test file: $e")
        return null
    }
}
