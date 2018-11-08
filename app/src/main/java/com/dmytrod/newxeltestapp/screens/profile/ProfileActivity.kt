package com.dmytrod.newxeltestapp.screens.profile

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dmytrod.newxeltestapp.App
import com.dmytrod.newxeltestapp.R
import com.dmytrod.newxeltestapp.screens.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_profile.*
import javax.inject.Inject

class ProfileActivity : AppCompatActivity() {

    @Inject
    lateinit var profileViewModelFactory: ProfileViewModelFactory
    private val cardsAdapter by lazy {
        CardsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        DaggerProfileComponent.builder()
                .appComponent((application as App).appComponent)
                .build()
                .inject(this)
        setupCardsRecyclerView()
        val viewModel = profileViewModelFactory.create(ProfileViewModel::class.java)
        subscribeToViewModel(viewModel)
        viewModel.loadProfile()
        viewModel.loadCards()
        settings.setOnClickListener {
            startActivity(SettingsActivity.createIntent(this))
        }
        mobile.setOnClickListener {
            Toast.makeText(this, R.string.mobile_message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupCardsRecyclerView() {
        cards.adapter = cardsAdapter
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        cards.layoutManager = linearLayoutManager
        PagerSnapHelper().attachToRecyclerView(cards)
    }

    private fun subscribeToViewModel(viewModel: ProfileViewModel) {
        viewModel.profile.observe(this, Observer { it ->
            it?.let { profile ->
                fullName.text = getString(R.string.full_name_format, profile.firstName, profile.lastName)
                profile.location?.let { data ->
                    location.text = getString(R.string.location_format, data.city, data.state)
                }
                Glide.with(this)
                        .load(profile.avatar?.imageUrl)
                        .apply(RequestOptions.circleCropTransform())
                        .into(headshot)
            }
        })
        viewModel.cards.observe(this, Observer { cardsAdapter.submitList(it) })
        viewModel.profileError.observe(this, Observer {
            if (it == true) Toast.makeText(this, R.string.profile_error, Toast.LENGTH_SHORT).show()
        })
        viewModel.cardsError.observe(this, Observer {
            if (it == true) Toast.makeText(this, R.string.cards_error, Toast.LENGTH_SHORT).show()
        })
    }
}
