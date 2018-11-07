package com.dmytrod.newxeltestapp.repositories

import com.dmytrod.newxeltestapp.model.Card
import com.dmytrod.newxeltestapp.model.Profile
import io.reactivex.Single

interface ProfileRepository {
    fun getProfile(): Single<Profile>
    fun getCards(): Single<List<Card>>
}
