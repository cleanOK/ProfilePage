package com.dmytrod.newxeltestapp.model

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("isDefault")
    val isDefault: Boolean = false,
    @SerializedName("imageUrl")
    val imageUrl: String = "",
    @SerializedName("width")
    val width: Int = 0,
    @SerializedName("height")
    val height: Int = 0
)
