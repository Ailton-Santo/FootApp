package com.example.footapp.di

import com.example.footapp.model.FootballApi
import com.example.footapp.model.CompetitionService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private val BASE_URL = "https://api.football-data.org"

    @Provides
    fun provideTeamApi(): FootballApi {

        return Retrofit.Builder() // Check Retrofit, GsonConverter and RxJava
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Converts Json code into Kotlin code
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(FootballApi::class.java)
    }

    @Provides
    fun provideCompetitionService(): CompetitionService{
        return CompetitionService()
    }
}