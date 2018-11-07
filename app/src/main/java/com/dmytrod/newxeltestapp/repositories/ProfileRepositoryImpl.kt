package com.dmytrod.newxeltestapp.repositories

import com.dmytrod.newxeltestapp.MobileTestService
import com.dmytrod.newxeltestapp.model.Card
import com.dmytrod.newxeltestapp.model.Profile
import io.reactivex.Single

class ProfileRepositoryImpl(private val mobileTestService: MobileTestService) : ProfileRepository {
    override fun getProfile(): Single<Profile> = mobileTestService.getProfile()

    override fun getCards(): Single<List<Card>> = mobileTestService.getCards()
        .map { it.cards }

}
