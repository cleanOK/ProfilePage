package com.dmytrod.newxeltestapp.screens.profile

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dmytrod.newxeltestapp.App
import com.dmytrod.newxeltestapp.R
import kotlinx.android.synthetic.main.activity_main.*
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
        viewModel.profile.observe(this, Observer { it ->
            it?.let { profile ->
                fullName.text = getString(R.string.full_name_format, profile.firstName, profile.lastName)
                profile.location?.let { data ->
                    location.text = getString(R.string.location_format, data.city, data.state)
                }
                //TODO avatar
            }
        })
        viewModel.cards.observe(this, Observer {
            //TODO
        })
        viewModel.loadProfile()
        viewModel.loadCards()
    }
}
