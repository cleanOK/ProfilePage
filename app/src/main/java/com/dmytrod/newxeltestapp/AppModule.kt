package com.dmytrod.newxeltestapp

import com.dmytrod.newxeltestapp.repositories.ProfileRepository
import com.dmytrod.newxeltestapp.repositories.ProfileRepositoryImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideProfileRepository(mobileTestService: MobileTestService): ProfileRepository {
        return ProfileRepositoryImpl(mobileTestService)
    }

    @Provides
    @Singleton
    fun provideMobileTestService(): MobileTestService {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpBuilder = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://s3-ap-southeast-2.amazonaws.com/openpay-mobile-test/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpBuilder.build())
            .build()
        return retrofit.create(MobileTestService::class.java)
    }
}
