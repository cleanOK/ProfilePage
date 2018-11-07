package com.dmytrod.newxeltestapp

import com.dmytrod.newxeltestapp.repositories.ProfileRepository
import com.dmytrod.newxeltestapp.repositories.ProfileRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideProfileRepository(): ProfileRepository {
        return ProfileRepositoryImpl()
    }
}
