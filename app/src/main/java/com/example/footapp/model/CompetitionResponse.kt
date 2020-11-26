package com.example.footapp.model

import com.google.gson.annotations.SerializedName

data class CompetitionResponse (
    @SerializedName("count")
    val count: Int,
    @SerializedName("competitions")
    val competitions: ArrayList<Competition>
)