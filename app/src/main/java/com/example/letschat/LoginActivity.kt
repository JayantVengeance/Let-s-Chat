package com.example.letschat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        edtEmail=findViewById(R.id.edit_email)
        edtPassword=findViewById(R.id.edit_password)
        btnLogin=findViewById(R.id.btn_login)
        btnSignUp=findViewById(R.id.btn_signup)
        mAuth= FirebaseAuth.getInstance()
        btnSignUp.setOnClickListener()
        {
            val Intent= Intent(this, Signup::class.java)
            startActivity(Intent)
        }
        btnLogin.setOnClickListener()
        {
            val email=edtEmail.text.toString().trim()
            val password=edtPassword.text.toString().trim()

            login(email, password);
        }
    }

    private fun login(email: String, password:String)
    {
        //code for logging in the user
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful)
                {
                    Toast.makeText(this@LoginActivity,"Logged In", Toast.LENGTH_SHORT).show()
                        val intent=Intent(this@LoginActivity, ListOfActivities::class.java)

                    finish()
                    startActivity(intent);
                } else {
                    // If sign in fails, display a message to the user.
                        Toast.makeText(this@LoginActivity,"User doesn't exist with these credentials", Toast.LENGTH_SHORT).show()
                }
            }

    }
}