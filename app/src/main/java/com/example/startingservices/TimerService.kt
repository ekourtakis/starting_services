package com.example.startingservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TimerService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startTimer()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun startTimer() {
        Thread {
            for (i in 100 downTo 0) {
                Log.d("TimerService", "Countdown: $i")
                Thread.sleep(1000) // 1-second delay
            }
            stopSelf()
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
