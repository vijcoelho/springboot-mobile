package com.api.finalproject.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.api.finalproject.R

class DisciplinasAdapter : RecyclerView.Adapter<DisciplinasAdapter.ViewHolder>() {

    private val disciplinas: MutableList<Disciplina> = mutableListOf()

    fun addDisciplina(disciplina: Disciplina) {
        disciplinas.add(disciplina)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_disciplina, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val disciplina = disciplinas[position]
        holder.bind(disciplina)
    }

    override fun getItemCount(): Int {
        return disciplinas.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewDisciplina: TextView = itemView.findViewById(R.id.textView_disciplina)

        fun bind(disciplina: Disciplina) {
            textViewDisciplina.text = disciplina.nome
        }
    }
}