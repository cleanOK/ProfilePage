package com.dmytrod.newxeltestapp.screens.profile

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.dmytrod.newxeltestapp.model.Cards
import com.dmytrod.newxeltestapp.model.Profile
import com.dmytrod.newxeltestapp.repositories.ProfileRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProfileViewModel(private val repository: ProfileRepository) : ViewModel() {
    val profile = MutableLiveData<Profile>()
    val cards = MutableLiveData<Cards>()
    private val disposables = CompositeDisposable()

    fun loadProfile() {
        disposables.add(
            repository.getProfile()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ profile.value = it },
                    { Log.e(LOG_TAG, "", it) })
        )
    }

    fun loadCards() {
        //TODO
        Log.d(LOG_TAG, "loadCards")
    }

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

    companion object {
        const val LOG_TAG = "ProfileViewModel"
    }
}
