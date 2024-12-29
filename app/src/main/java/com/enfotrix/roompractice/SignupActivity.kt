package com.enfotrix.roompractice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class SignupActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signupButton: Button
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        signupButton = findViewById(R.id.signup_button)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        signupButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            val user = User(username = username, password = password)
            userViewModel.insertUser(user)
            Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
        }
    }
}
