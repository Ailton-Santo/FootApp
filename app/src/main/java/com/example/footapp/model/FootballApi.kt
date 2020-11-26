package com.example.footapp.model

import io.reactivex.Single
import retrofit2.http.GET


interface FootballApi {
    @GET("/v2/competitions/")
    fun retrieveCompetitions(): Single<CompetitionResponse>
}