package com.dmytrod.newxeltestapp.model

import com.google.gson.annotations.SerializedName

data class Avatar(
    @SerializedName("imageUrl")
    val imageUrl: String?,
    @SerializedName("width")
    val width: Int? = 0,
    @SerializedName("height")
    val height: Int? = 0
)
