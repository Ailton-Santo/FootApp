package com.example.footapp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.footapp.R
import com.example.footapp.viewmodel.CompetitionViewModel
import kotlinx.android.synthetic.main.activity_team.*

class CompetitionActivity : AppCompatActivity() {

    lateinit var viewModel: CompetitionViewModel
    private val competitionAdapter = CompetitionAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        viewModel = ViewModelProvider(this).get(CompetitionViewModel::class.java)
        viewModel.refresh()


        findViewById<RecyclerView>(R.id.competitionList).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = competitionAdapter
        }

        observeViewModel()
    }

    fun observeViewModel() {

        viewModel.competitions.observe(this, Observer { competitions ->
            competitions?.let {
                competitionList.visibility = View.VISIBLE
                competitionAdapter.updateCompetitions(it.competitions)

            }
        })
    }
}