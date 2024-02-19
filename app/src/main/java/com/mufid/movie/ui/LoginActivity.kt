package com.mufid.movie.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mufid.movie.MainActivity
import com.mufid.movie.data.local.UserPreferences
import com.mufid.movie.data.response.ResponseLogin
import com.mufid.movie.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            submitLogin()
        }
    }

    private fun submitLogin() {
        val username = binding.valueUsername
        val password = binding.valuePassword

        if (username != null && password != null) {
            val database = UserPreferences(this)
            val user = ResponseLogin()
            user.username = username.text.toString()
            user.password = password.text.toString()

            database.setUser(user)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
