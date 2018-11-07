package com.dmytrod.newxeltestapp

import com.dmytrod.newxeltestapp.model.Cards
import com.dmytrod.newxeltestapp.model.Profile
import io.reactivex.Single
import retrofit2.http.GET

interface MobileTestService {
    @GET("profile.json")
    fun getProfile(): Single<Profile>

    @GET("cards.json")
    fun getCards(): Single<Cards>
}
