package com.example.w1d4_l5_hw_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    fun createAcc(view: View) {

        val fname = fname.text.toString()
        val lname = lname.text.toString()
        val email = email.text.toString()
        val pword = passW.text.toString()

        var userCreate: User? = null

        if (fname != "" && lname != "" && email != "" && pword != "") {
            userCreate = User(fname, lname, email, pword)

        }
        val intent = getIntent()
        var listOfUsers = intent.getSerializableExtra("userList") as ArrayList<User>
        if (userCreate != null && listOfUsers != null) {

            listOfUsers.add(userCreate)

            Toast.makeText(this, " Account created successfully", Toast.LENGTH_LONG).show()
            val intentMain = Intent(this, MainActivity::class.java)
            intentMain.putExtra("listOfUsers", listOfUsers)
            startActivity(intentMain)
        } else {
            Toast.makeText(this, " Account created Failed", Toast.LENGTH_LONG).show()
//            val editTextfname = findViewById(R.id.fname) as EditText
//            editTextfname.setText("")
//
//            val editTextlname = findViewById(R.id.lname) as EditText
//            editTextlname.setText("")
//
//
//            val editTextemail = findViewById(R.id.email) as EditText
//            editTextemail.setText("")
//
//            val editTextpword = findViewById(R.id.passW) as EditText
//            editTextpword.setText("")
        }
    }

}
