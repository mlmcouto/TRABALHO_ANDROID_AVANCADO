package com.example.trabalho_android_avancado

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat

class StartApp: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action.equals(Intent.ACTION_MAIN)) {
            Log.d("Inicio do Programa", "O APP iniciou: " +
                    "${intent.getBooleanExtra("state", false)}")

            callAirPlaneNotification(context, intent.getBooleanExtra("state", false))
        } else {
            Log.e("Inicio do Programa", "Aconteceu algum problema, Action ${intent.action}")
        }

    }

    private fun callAirPlaneNotification(context: Context, state: Boolean) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        intent.putExtra("state", state)

        val pedingIntent = PendingIntent.getActivity(context, 1234,
            intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(context, "MYAPP")
        builder.setSmallIcon(R.drawable.ic_launcher_foreground)
        builder.setContentTitle("My app notification")
        builder.setContentText("O Programa iniciou ")
        builder.setPriority(NotificationCompat.PRIORITY_HIGH)
        builder.setAutoCancel(true)
        builder.setContentIntent(pedingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel("MYAPP",
                "My Application", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notification = builder.build()
        notificationManager.notify(1234, notification)

    }
}