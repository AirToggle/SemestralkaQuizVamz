package com.example.semestralka_quiz_geo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.content.ContextCompat

class Notifikacia {



    fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notifikacie"
            val descriptionText = "čo ja viem"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("notif", name, importance).apply {
                description = descriptionText
            }
            val notificationManager = ContextCompat.getSystemService(context, NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
    }
}