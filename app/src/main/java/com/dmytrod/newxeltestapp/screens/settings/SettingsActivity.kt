package com.dmytrod.newxeltestapp.screens.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dmytrod.newxeltestapp.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, SettingsActivity::class.java)
    }
}
