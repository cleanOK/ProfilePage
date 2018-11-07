package com.dmytrod.newxeltestapp.model


import com.google.gson.annotations.SerializedName


data class Profile(@SerializedName("firstName")
                   val firstName: String = "",
                   @SerializedName("lastName")
                   val lastName: String = "",
                   @SerializedName("location")
                   val location: Location?,
                   @SerializedName("avatar")
                   val avatar: Avatar)


