package com.dmytrod.newxeltestapp.screens.profile

import com.dmytrod.newxeltestapp.AppComponent
import com.dmytrod.newxeltestapp.PerActivity
import dagger.Component

@PerActivity
@Component(
    dependencies = [AppComponent::class],
    modules = [ProfileModule::class]
)
interface ProfileComponent {
    fun inject(activity: ProfileActivity)
}
