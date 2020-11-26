package com.example.footapp.model

import com.google.gson.annotations.SerializedName

data class Area (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("countryCode")
    val countryCode: String
)