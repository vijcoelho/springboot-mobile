package com.api.finalproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {

    private lateinit var emailEdt: EditText
    private lateinit var senhaEdt: EditText
    private lateinit var btnRegistrar: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        emailEdt = findViewById(R.id.edt_registroEmail)
        senhaEdt = findViewById(R.id.edt_registroSenha)
        btnRegistrar = findViewById(R.id.btn_registrando)

        btnRegistrar.setOnClickListener {
            val email = emailEdt.text.toString()
            val senha = senhaEdt.text.toString()

            auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        val uid = user?.uid?: ""
                        val database = FirebaseDatabase.getInstance().reference
                        val userRef = database.child("user").child(uid)
                        userRef.child("email").setValue(email)
                            .addOnCompleteListener {databaseTask ->
                                if (databaseTask.isSuccessful) {
                                    Toast.makeText(this, "Registro realizado com sucesso", Toast.LENGTH_SHORT).show()
                                    startActivity(Intent(this@Register, MainActivity::class.java))
                                    finish()
                                } else {
                                    Toast.makeText(this, "Deu errado", Toast.LENGTH_SHORT).show()
                                }
                            }
                    } else {
                        val exception = task.exception
                        Log.e("RegisterActivity", "Falha no registro", exception)
                        Toast.makeText(this, "Erro ao registrar: ${exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}