package com.dmytrod.newxeltestapp.screens.profile

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.dmytrod.newxeltestapp.repositories.ProfileRepository

class ProfileViewModel(private val repository: ProfileRepository) : ViewModel() {
    fun loadProfile() {
        Log.d(LOG_TAG, "loadProfile")
    }

    fun loadCards() {
        Log.d(LOG_TAG, "loadCards")
    }

    companion object {
        const val LOG_TAG = "ProfileViewModel"
    }
}
