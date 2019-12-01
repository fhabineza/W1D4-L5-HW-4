package com.example.w1d4_l5_hw_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    //Create list od Users
    var userList: ArrayList<User> = arrayListOf<User>()
    var user1 = User("Tim", "Caroll", "caroll@gmail.com", "123")
    var user2 = User("Jim", "Carey", "carey@gmail.com", "123")
    var user3 = User("Bob", "Marley", "marley@gmail.com", "123")
    var user4 = User("Mo", "Salah", "salah@gmail.com", "123")
    var user5 = User("Sadio", "mane", "mane@gmail.com", "123")


    var listOfUsers : ArrayList<User>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //adding User  in the list
        userList.add(user1)
        userList.add(user2)
        userList.add(user3)
        userList.add(user4)
        userList.add(user5)




    }

    fun signin(view: View) {

        val inteList = intent
        var uList = userList
        try {
            listOfUsers = inteList.getSerializableExtra("listOfUsers") as ArrayList<User>

        }catch (e:Exception){

        }
           if(listOfUsers != null){
              uList  = listOfUsers as ArrayList<User>
           }

        if(userList.size < uList.size){
            userList = uList
        }


        val username = userName.text.toString()
        val password = passWord.text.toString()

        var userFound: User? = null



        for (user in userList) {
            var uname = user.username
            var pword = user.password
            if (username.equals(uname) && password.equals(pword)) {
                userFound = user
            }
        }

        if (userFound != null) {
            Toast.makeText(this, "Login successfully", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ProductsCategory::class.java)
            intent.putExtra("userFound", userFound)
            startActivity(intent)

        } else {
            Toast.makeText(this, "User not found", Toast.LENGTH_LONG).show()
            val uEtext = findViewById(R.id.userName) as EditText
            uEtext.setText("")

            val pEtext = findViewById(R.id.passWord) as EditText
            pEtext.setText("")
        }
    }

    fun createAccount(view: View) {
        val intent = Intent(this, SignupActivity::class.java)
        intent.putExtra("userList", userList)
        startActivity(intent)
    }

    fun forgot(view: View) {
        val intent = Intent(this, ForgotActivity::class.java)
        intent.putExtra("userList", userList)
        startActivity(intent)
    }


}
