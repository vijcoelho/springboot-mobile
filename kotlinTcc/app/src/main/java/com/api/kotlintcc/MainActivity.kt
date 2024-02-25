package com.api.kotlintcc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.api.kotlintcc.model.User
import com.api.kotlintcc.retrofit.RetrofitServer
import com.api.kotlintcc.retrofit.UserRetrofit
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.String
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.Throwable


class MainActivity : AppCompatActivity() {

    private lateinit var loginButton: MaterialButton
    private lateinit var emailInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var retrofitServer: RetrofitServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.loginButton)
        emailInput = findViewById(R.id.emailInput)
        passwordInput = findViewById(R.id.passwordInput)

        loginButton.setOnClickListener { v -> loginButtonClick(v) }

    }

    fun loginButtonClick(view: View) {
        if(view == loginButton) {
            val email: kotlin.String = String.valueOf(emailInput.getText())
            val password: kotlin.String = String.valueOf(passwordInput.getText())

            val user = User()
            user.setEmail(email)
            user.setPassword(password)

            authenticateUser(user)
        }
    }

    private fun authenticateUser(user: User) {
        val userRetrofit: UserRetrofit = retrofitServer.getAuthUser()
        val call: Call<ResponseBody> = userRetrofit.authenticatorUser(user)
        call.enqueue(object: Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    startActivity(Intent(this@MainActivity, Start::class.java))
                    finish()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error during authentication", Toast.LENGTH_SHORT)
                    .show()
                Logger.getLogger(MainActivity::class.java.name).log(Level.SEVERE, "ERROR:", t)
            }

        })
    }
}