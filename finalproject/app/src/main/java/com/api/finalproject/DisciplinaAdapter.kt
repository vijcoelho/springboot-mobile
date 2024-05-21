package com.api.finalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class DisciplinaAdapter(context: Context, private val disciplinas: List<Disciplina>) :
    ArrayAdapter<Disciplina>(context, 0, disciplinas) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false)
        }
        val disciplina = disciplinas[position]

        view?.findViewById<TextView>(android.R.id.text1)?.text = disciplina.nome
        return view!!
    }
}
