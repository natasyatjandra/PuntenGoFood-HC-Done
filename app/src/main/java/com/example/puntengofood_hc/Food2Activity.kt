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

class Food2Activity:AppCompatActivity() {
    lateinit var iv1: ImageView
    lateinit var iv2: ImageView
    lateinit var iv3: ImageView
    lateinit var db2: DatabaseReference

    lateinit var but1: Button
    lateinit var but2: Button
    lateinit var but3: Button
    lateinit var but4: Button

    lateinit var butha1: Button
    lateinit var butha2: Button
    lateinit var butha3: Button

    lateinit var tvTot: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food2)

        iv1 = findViewById(R.id.ivMenu1)
        iv2 = findViewById(R.id.ivMenu2)
        iv3 = findViewById(R.id.ivMenu3)

        butha1 = findViewById(R.id.butha1)
        butha2 = findViewById(R.id.butha2)
        butha3 = findViewById(R.id.butha3)

        but1 = findViewById(R.id.but1)
        but2 = findViewById(R.id.but2)
        but3 = findViewById(R.id.but3)
        but4 = findViewById(R.id.but4)

        tvTot = findViewById(R.id.tvTotal)

        var Total = 0
        var qty1=0
        var qty2=0
        var qty3=0

        db2 = Firebase.database.reference


        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Food2%20Icon%2FPentol1.jpg?alt=media&token=7f213bc5-9bcc-4989-b3ea-92b6a6dce144")
            .into(iv1)
        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Food2%20Icon%2FPentol2.jpg?alt=media&token=94b2c368-598e-45aa-8c6d-edaba4aabc33")
            .into(iv2)
        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Food2%20Icon%2FPentol3.webp?alt=media&token=9b429d46-5e1b-4a6a-ae1e-f283bc5bde19")
            .into(iv3)

        but1.setOnClickListener{
            Total+=15000
            qty1+=1
            tvTot.setText(Total.toString())
        }

        but2.setOnClickListener{
            Total+=25000
            qty2+=1
            tvTot.setText(Total.toString())
        }
        but3.setOnClickListener{
            Total+=10000
            qty3+=1
            tvTot.setText(Total.toString())
        }

        but4.setOnClickListener {
            var transaction = Food1Obj("Sate Pentol Bakar",qty1.toString(),"Pentol Kuah Huhah",qty2.toString(),"Pentol Original",qty3.toString(),Total.toString())
            db2.child("Transaction History Pentol Corah Bang Huhah").push().setValue(transaction)
            Total = 0
            tvTot.setText(Total.toString())
            Toast.makeText(this, "History stored to Firebase", Toast.LENGTH_SHORT).show()
        }

        butha1.setOnClickListener {
            if(qty1<=0){
                Toast.makeText(this, "Tidak dapat dikurangi", Toast.LENGTH_SHORT).show()
                qty1=0
            }else {
                qty1-=1
                Total -= 15000
                tvTot.setText(Total.toString())
            }
        }

        butha2.setOnClickListener {
            if(qty2<=0){
                Toast.makeText(this, "Tidak dapat dikurangi", Toast.LENGTH_SHORT).show()
                qty2=0
            }else {
                qty2-=1
                Total -= 25000
                tvTot.setText(Total.toString())
            }
        }
        butha3.setOnClickListener {
            if(qty3<=0){
                Toast.makeText(this, "Tidak dapat dikurangi", Toast.LENGTH_SHORT).show()
                qty3=0
            }else {
                qty3-=1
                Total -= 10000
                tvTot.setText(Total.toString())
            }
        }

    }


}