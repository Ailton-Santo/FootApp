package com.example.footapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footapp.R
import com.example.footapp.model.Competition


class CompetitionAdapter(var competitions: ArrayList<Competition>) :
    RecyclerView.Adapter<CompetitionAdapter.CompetitionViewHolder>() {

    fun updateCompetitions(newCompetition: ArrayList<Competition>) {

        competitions.clear()
        competitions.addAll(newCompetition)
        notifyDataSetChanged()
    }

    class CompetitionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val competitionId = view.findViewById(R.id.label_id) as TextView
        val competitionName = view.findViewById(R.id.label_name) as TextView
        val competitionCountryName = view.findViewById(R.id.label_area) as TextView

        fun bind(competition: Competition) {
            competitionId.text = competition.id.toString()
            competitionName.text = competition.name
            competitionCountryName.text = competition.area.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CompetitionViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.team_list, parent, false)
    )


    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        holder.bind(competitions[position])
    }

    override fun getItemCount() = competitions.size

}
