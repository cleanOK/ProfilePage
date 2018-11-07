package com.dmytrod.newxeltestapp.model

import com.google.gson.annotations.SerializedName

data class Location(@SerializedName("country")
                    val country: String = "",
                    @SerializedName("city")
                    val city: String = "",
                    @SerializedName("state")
                    val state: String? = "")
