package com.dmytrod.newxeltestapp

import com.dmytrod.newxeltestapp.repositories.ProfileRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun provideProfileRepository(): ProfileRepository
    fun provideMobileTestService(): MobileTestService
}
