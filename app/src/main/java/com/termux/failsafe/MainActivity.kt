package com.termux.failsafe

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent("com.termux.service_execute")
        intent.setClassName("com.termux", "com.termux.app.TermuxService")
        intent.putExtra("com.termux.app.failsafe_session", true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // https://developer.android.com/about/versions/oreo/background.html
            startForegroundService(intent)
        } else {
            startService(intent)
        }

        finish()
    }

}
