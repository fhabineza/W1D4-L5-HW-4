package com.example.w1d4_l5_hw_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class ProductsCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_category)

        val intent = getIntent()
        val user = intent.getSerializableExtra("userFound") as User

        val userTitle = findViewById(R.id.userTitle) as TextView
        userTitle.setText("Welcome ${user.username}")

        val img1 = findViewById(R.id.img1) as ImageView
        img1.setOnClickListener(){
            Toast.makeText(this, "You have chosen the Electronics category of shopping", Toast.LENGTH_LONG).show()
        }
        val img2 = findViewById(R.id.img2) as ImageView
        img2.setOnClickListener(){
            Toast.makeText(this, "You have chosen the Food category of shopping", Toast.LENGTH_LONG).show()
        }
        val img3 = findViewById(R.id.img3) as ImageView
        img3.setOnClickListener(){
            Toast.makeText(this, "You have chosen the Shoes category of shopping", Toast.LENGTH_LONG).show()
        }
        val img4 = findViewById(R.id.img4) as ImageView
        img4.setOnClickListener(){
            Toast.makeText(this, "You have chosen the beauty category of shopping", Toast.LENGTH_LONG).show()
        }


    }
}
