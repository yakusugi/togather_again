package com.undeniabledreams.togather_again.main.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.undeniabledreams.togather_again.R
import com.undeniabledreams.togather_again.main.dao.UserRegistrationDao
import com.undeniabledreams.togather_again.main.dto.UserDto
import java.io.IOException

class LoginActivity : AppCompatActivity() {



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signInBtn: Button = findViewById(R.id.login_btn)
        val emailEdtTxt: EditText = findViewById(R.id.edit_text_login_email)
        val passwordEdtTxt: EditText = findViewById(R.id.edit_text_login_pw)
        val signUpTxt: TextView = findViewById(R.id.text_view_sign_up)
        val pwForgotText: TextView = findViewById(R.id.text_view_fortgot_pw)

        signUpTxt.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        signInBtn.setOnClickListener {
            val emailAddress: String = emailEdtTxt.getText().toString()
            val userPassword: String = passwordEdtTxt.getText().toString()

            val userDto = UserDto(emailAddress, userPassword)
            val userRegistrationDao = UserRegistrationDao(this)
            try {
                userRegistrationDao.logIn(userDto) { result ->
                    if (result == 1) {
                        Toast.makeText(this@LoginActivity, "Login successful!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@LoginActivity, "Login failed!", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: IOException) {
                Toast.makeText(this@LoginActivity, "Error in logging in!", Toast.LENGTH_SHORT).show()
                e.printStackTrace()

            }

        }

    }
}