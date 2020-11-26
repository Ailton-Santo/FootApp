package com.example.footapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.footapp.di.DaggerApiComponent
import com.example.footapp.model.Competition
import com.example.footapp.model.CompetitionResponse
import com.example.footapp.model.CompetitionService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CompetitionViewModel : ViewModel() {
    @Inject
    lateinit var competitionService: CompetitionService

    init {
        DaggerApiComponent.create().inject(this)
    }

    private val disposable = CompositeDisposable()

    val competitions = MutableLiveData<CompetitionResponse>()


    fun refresh () {
        fetchCompetitions()
    }

    private fun fetchCompetitions () {
        disposable.add(
            competitionService.getCompetitions()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object:
                    DisposableSingleObserver<CompetitionResponse>(){
                    override fun onSuccess(value: CompetitionResponse?) {
                        competitions.value = value
                    }

                    override fun onError(e: Throwable?) {
                        println("Error")
                    }
                })
        )
    }
}