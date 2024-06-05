package com.example.semestralka_quiz_geo

data class Otazka(
    val question: String,
    val image_url: String,
    val A: String,
    val B: String,
    val C: String,
    val D: String,
    val answer: String,
    val type: String
)