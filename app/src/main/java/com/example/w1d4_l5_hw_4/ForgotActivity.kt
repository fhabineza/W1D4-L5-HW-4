package com.example.w1d4_l5_hw_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_forgot.*
import kotlinx.android.synthetic.main.activity_signup.*

class ForgotActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)
    }

    fun forgotPwd(view: View) {
        var userEmail = emailEdit.text.toString()
        val intentUsers = getIntent()
        val usersList = intentUsers.getSerializableExtra("userList") as ArrayList<User>

        if(userEmail != "") {
            for (user in usersList) {
                if (user.username.equals(userEmail)) {
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT, "Your password is : ${user.password}")
                    startActivity(intent)

                }
            }
        }else{
            Toast.makeText(
                this,
                "Please try again",
                Toast.LENGTH_LONG
            ).show()
        }


    }
}
