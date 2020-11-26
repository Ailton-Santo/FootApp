package com.example.footapp.model

import com.example.footapp.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class CompetitionService {
    @Inject
    lateinit var api: FootballApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getCompetitions(): Single<CompetitionResponse> {
        return api.retrieveCompetitions()
    }
}