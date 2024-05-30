package com.api.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var btnRegistro: Button
    private lateinit var emailEdt: EditText
    private lateinit var senhaEdt: EditText
    private lateinit var btnLogin: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)

        auth = FirebaseAuth.getInstance()

        emailEdt = findViewById(R.id.edt_email)
        senhaEdt = findViewById(R.id.edt_senha)
        btnLogin = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            val email = emailEdt.text.toString()
            val senha = senhaEdt.text.toString()

            auth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Login realizado com sucesso", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@MainActivity, GoogleMaps::class.java))
                        finish()
                    } else {
                        val exception = task.exception
                        Toast.makeText(this, "Error $exception", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        btnRegistro = findViewById(R.id.btn_registrar)

        btnRegistro.setOnClickListener {
            startActivity(Intent(this@MainActivity, Register::class.java))
            finish()
        }
    }
}