package com.dmytrod.newxeltestapp.screens.profile

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.dmytrod.newxeltestapp.repositories.ProfileRepository
import javax.inject.Inject

class ProfileViewModelFactory @Inject constructor(private val profileRepository: ProfileRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == ProfileViewModel::class.java) {
            return ProfileViewModel(profileRepository) as T
        }
        throw IllegalArgumentException("modelClass should be ProfileViewModel.class")
    }
}
