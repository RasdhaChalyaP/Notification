package com.rasdha.stematel.notification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class BaseApp : Application() {

    companion object{
        const val NOTIF_1_ID = "notif1"
        const val NOTIF_2_ID = "notif2"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notif1 = NotificationChannel(
                NOTIF_1_ID,
                "Notif Satu",
                NotificationManager.IMPORTANCE_HIGH
            )
            notif1.description = "Ini adalah notification 1"

            val notif2 = NotificationChannel(
                NOTIF_2_ID,
                "Notif Dua",
                NotificationManager.IMPORTANCE_LOW
            )
            notif2.description = "Ini adalah notification 2"

            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(notif1)
            manager?.createNotificationChannel(notif2)
        }
    }
}