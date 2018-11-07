package com.dmytrod.newxeltestapp.screens.profile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dmytrod.newxeltestapp.App
import com.dmytrod.newxeltestapp.R
import javax.inject.Inject

class ProfileActivity : AppCompatActivity() {

    @Inject
    lateinit var profileViewModelFactory: ProfileViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerProfileComponent.builder()
            .appComponent((application as App).appComponent)
            .build()
            .inject(this)
        val viewModel = profileViewModelFactory.create(ProfileViewModel::class.java)
        viewModel.loadProfile()
        viewModel.loadCards()
    }
}
