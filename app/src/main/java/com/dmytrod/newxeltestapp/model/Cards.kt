package com.dmytrod.newxeltestapp.model

import com.google.gson.annotations.SerializedName

data class Cards(@SerializedName("cards")
                 val cards: List<Card>?)
