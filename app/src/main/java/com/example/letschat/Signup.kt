package com.example.letschat

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Signup : AppCompatActivity() {

    private lateinit var edtname: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignUp: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        mAuth= FirebaseAuth.getInstance()
        edtEmail=findViewById(R.id.edit_email)
        edtname=findViewById(R.id.edit_name)
        edtPassword=findViewById(R.id.edit_password)
        btnSignUp=findViewById(R.id.btn_signup)




        btnSignUp.setOnClickListener()
        {
            //Don't forget to trim the string
            val name=edtname.text.toString().trim()
            val email=edtEmail.text.toString().trim()
            val password=edtPassword.text.toString().trim()

            signup(name, email, password)
        }
    }
    private fun signup(name: String, email: String, password:String)
    {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful)
                {
                    //Adding user to the database
                    addUserToDatatbase(name, email, mAuth.currentUser?.uid!!)

                   //code for jumping to home activity
                    Toast.makeText(this@Signup, "User Created Successfully!!!!!", Toast.LENGTH_SHORT).show()
                    val intent= Intent(this@Signup, ListOfActivities::class.java )

                    finish()
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this@Signup, "Some Error Occured", Toast.LENGTH_SHORT).show()
                }
            }

    }
    private fun addUserToDatatbase(name : String, email: String, uid: String)
    {
            mDbRef=FirebaseDatabase.getInstance().getReference()

            mDbRef.child("user").child(uid).setValue(User(name, email, uid))

    }
}