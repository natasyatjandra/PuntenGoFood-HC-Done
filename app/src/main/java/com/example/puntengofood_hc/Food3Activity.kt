package com.example.puntengofood_hc

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Food3Activity:AppCompatActivity() {
    lateinit var iv1: ImageView
    lateinit var iv2: ImageView
    lateinit var iv3: ImageView
    lateinit var db1: DatabaseReference
    lateinit var but1: Button
    lateinit var but2: Button
    lateinit var but3: Button
    lateinit var but4: Button

    lateinit var tvTot: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food3)

        iv1 = findViewById(R.id.ivMenu1)
        iv2 = findViewById(R.id.ivMenu2)
        iv3 = findViewById(R.id.ivMenu3)

        but1 = findViewById(R.id.but1)
        but2 = findViewById(R.id.but2)
        but3 = findViewById(R.id.but3)
        but4 = findViewById(R.id.but4)

        tvTot = findViewById(R.id.tvTotal)

        var Total = 0

        db1 = Firebase.database.reference



        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Food3%20icon%2Fmenu1.jpg?alt=media&token=efd4dbb6-884f-448c-89e7-cdf5d068b397")
                .into(iv1)
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Food3%20icon%2Fmenu2.jpg?alt=media&token=8a4f1b38-119d-4740-a996-a2fd79e0c6e2")
                .into(iv2)
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Food3%20icon%2Fmenu3.jpg?alt=media&token=ad4736e7-6e5d-45c8-9b8a-50279f98daea")
                .into(iv3)

        but1.setOnClickListener{
            Total+=25000
            tvTot.setText(Total.toString())
        }

        but2.setOnClickListener{
            Total+=25000
            tvTot.setText(Total.toString())
        }
        but3.setOnClickListener{
            Total+=10000
            tvTot.setText(Total.toString())
        }

        but4.setOnClickListener {
            var transaction = Food1Obj("Coffeein Hati",Total.toString())
            db1.child("Transaction History Resto 3").push().setValue(transaction)
            Total = 0
            tvTot.setText(Total.toString())
            Toast.makeText(this, "Transaction stored to Firebase", Toast.LENGTH_SHORT).show()
        }


    }


}