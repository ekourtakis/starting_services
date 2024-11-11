package com.example.startingservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TimerService : Service() {
    private val serviceScope = CoroutineScope(Dispatchers.IO + Job())

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startTimer()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun startTimer() {
        serviceScope.launch {
            for (i in 100 downTo 0) {
                Log.d("Timer", i.toString())
                Thread.sleep(1000) // 1-second delay
            }
            stopSelf()
        }.start()
    }
}
