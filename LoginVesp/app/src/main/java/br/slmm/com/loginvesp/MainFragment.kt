package br.slmm.com.loginvesp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.slmm.com.loginvesp.databinding.FragmentMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth : FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var disciplinasAdapter: DisciplinasAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        database = FirebaseDatabase.getInstance().reference.child("disciplinas")

        // Configurar RecyclerView
        disciplinasAdapter = DisciplinasAdapter()
        binding.recyclerviewDisciplinas.adapter = disciplinasAdapter

        carregarDisciplinas()

        binding.btnSignOut.setOnClickListener {
            auth.signOut()
            findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
        }
    }

    private fun carregarDisciplinas() {
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val disciplinasList = mutableListOf<Disciplina>()
                for (disciplinaSnapshot in snapshot.children) {
                    val disciplina = disciplinaSnapshot.getValue(Disciplina::class.java)
                    disciplina?.let {
                        disciplinasList.add(it)
                    }
                }
                disciplinasAdapter.setItems(disciplinasList)
            }

            override fun onCancelled(error: DatabaseError) {
                // Trate qualquer erro aqui
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
