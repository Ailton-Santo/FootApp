package com.example.footapp.model

import com.google.gson.annotations.SerializedName

data class Competition(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("area")
    val area: Area
)