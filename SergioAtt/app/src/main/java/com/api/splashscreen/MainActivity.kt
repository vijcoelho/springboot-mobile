package com.api.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.api.splashscreen.databinding.ActivityMainBinding
import com.api.splashscreen.model.User
import com.api.splashscreen.retrofit.RetrofitServer
import com.api.splashscreen.retrofit.UserRetrofit
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Level
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    private lateinit var retrofit: RetrofitServer
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = RetrofitServer()

    }

    fun loginOnClick(view: View) {
        if (view == binding.btnLogin) {
            val email: String = binding.edtEmail.text.toString()
            val password: String = binding.edtSenha.text.toString()

            val user = User()
            user.setEmail(email)
            user.setPassword(password)

            authenticatorUser(user)
        }
    }

    private fun authenticatorUser(user: User) {
        val userRetrofit: UserRetrofit = retrofit.getAuthUser()
        val call: Call<ResponseBody> = userRetrofit.authenticatorUser(user)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    startActivity(Intent(this@MainActivity, Disciplinas::class.java))
                    finish()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error during authentication", Toast.LENGTH_SHORT)
                    .show()
                Logger.getLogger(MainActivity::class.java.name).log(Level.SEVERE, "ERROR", t)
            }
        })
    }
}