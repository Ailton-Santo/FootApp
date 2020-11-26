package com.example.footapp.di

import com.example.footapp.model.CompetitionService
import com.example.footapp.viewmodel.CompetitionViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: CompetitionService)

    fun inject(viewModel: CompetitionViewModel)
}