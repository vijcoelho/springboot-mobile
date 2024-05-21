package com.api.finalproject

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DisciplinasActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var edtNomeDisciplina: EditText
    private lateinit var btnAdicionar: Button
    private lateinit var database: FirebaseDatabase
    private lateinit var disciplinasRef: DatabaseReference
    private lateinit var disciplinasList: MutableList<Disciplina>
    private lateinit var adapter: DisciplinaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disciplinas)

        listView = findViewById(R.id.listView)
        edtNomeDisciplina = findViewById(R.id.edt_nome_disciplina)
        btnAdicionar = findViewById(R.id.btn_adicionar)

        database = FirebaseDatabase.getInstance()
        disciplinasRef = database.getReference("disciplinas")
        disciplinasList = mutableListOf()

        adapter = DisciplinaAdapter(this, disciplinasList)
        listView.adapter = adapter

        btnAdicionar.setOnClickListener {
            val nomeDisciplina = edtNomeDisciplina.text.toString()
            if (nomeDisciplina.isNotBlank()) {
                adicionarDisciplina(nomeDisciplina)
                edtNomeDisciplina.text.clear()
            } else {
                Toast.makeText(this, "Por favor, insira o nome da disciplina", Toast.LENGTH_SHORT).show()
            }
        }

        carregarDisciplinasDoBancoDeDados()
    }

    private fun carregarDisciplinasDoBancoDeDados() {
        disciplinasRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                disciplinasList.clear()
                for (disciplinaSnapshot in snapshot.children) {
                    val nomeDisciplina = disciplinaSnapshot.getValue(String::class.java)
                    nomeDisciplina?.let {
                        val disciplina = Disciplina(it)
                        disciplinasList.add(disciplina)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG, "Erro ao carregar disciplinas do banco de dados", error.toException())
            }
        })
    }

    private fun adicionarDisciplina(nome: String) {
        val novaDisciplinaRef = disciplinasRef.push()
        novaDisciplinaRef.setValue(nome)
            .addOnSuccessListener {
                Toast.makeText(this, "Disciplina adicionada com sucesso", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { error ->
                Log.e(TAG, "Erro ao adicionar disciplina ao banco de dados", error)
                Toast.makeText(this, "Erro ao adicionar disciplina", Toast.LENGTH_SHORT).show()
            }
    }
}


