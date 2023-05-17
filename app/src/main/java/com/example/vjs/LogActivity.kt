package com.example.vjs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogActivity : AppCompatActivity() {
    private lateinit var EdtUser: EditText
    private lateinit var Edtpass: EditText
    private lateinit var Tvdirect: TextView
    private lateinit var Btnlogin: Button
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)
        EdtUser=findViewById(R.id.Edt_Uname)
        Edtpass=findViewById(R.id.Edt_pass)
        Tvdirect=findViewById(R.id.txt_forgotpass)
        auth= Firebase.auth

        Tvdirect.setOnClickListener {
            val intent = Intent(this, LogActivity::class.java)
            startActivity(intent)
        }
        Btnlogin.setOnClickListener {
            LoginUser()
            val intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }
    private fun LoginUser(){
        val pass=Edtpass.text.toString()
        if (pass.isBlank()){
            Toast.makeText(this,"Please username and password can not be blank", Toast.LENGTH_LONG).show()
            return
        }else Toast.makeText(this,"Please enter username and password", Toast.LENGTH_LONG).show()
    }
}