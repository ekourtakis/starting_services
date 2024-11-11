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
        val num = intent?.getIntExtra("key", 100)
        if (num != null) {
            startTimer(num)
        }
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun startTimer(num: Int) {
        serviceScope.launch {
            for (i in num downTo 0) {
                Log.d("Timer", i.toString())
                Thread.sleep(1000)
            }
            Log.d("Timer", "finished")
            stopSelf()
        }.start()
    }
}
