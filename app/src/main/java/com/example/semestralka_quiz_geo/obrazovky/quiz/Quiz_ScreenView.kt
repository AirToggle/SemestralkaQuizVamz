package com.example.semestralka_quiz_geo.obrazovky.quiz

import android.content.Context
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semestralka_quiz_geo.Otazka.NacitajOtazky
import com.example.semestralka_quiz_geo.Otazka.Otazka
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Quiz_ScreenView : ViewModel() {
    var questions = mutableStateOf<List<Otazka>>(emptyList())
    var currentQuestionIndex = mutableIntStateOf(0)

    fun loadQuestions(context: Context) {
        viewModelScope.launch {
            questions.value = withContext(Dispatchers.IO) {
                NacitajOtazky(context)
            }
        }
    }


    fun nextQuestion() {
        if (currentQuestionIndex.intValue < questions.value.size) {
            currentQuestionIndex.intValue++
        }
    }

    fun resetQuiz() {
        currentQuestionIndex = mutableIntStateOf(0)
    }

    fun checkAnswer(answer: String): Boolean {
        if (questions.value[currentQuestionIndex.intValue].answer == answer ) {
            return true
        }
        return false
    }


}
