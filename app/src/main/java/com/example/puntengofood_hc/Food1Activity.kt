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

class Food1Activity:AppCompatActivity() {
    lateinit var iv1: ImageView
    lateinit var iv2: ImageView
    lateinit var iv3: ImageView

    lateinit var db1: DatabaseReference
    lateinit var tvTot: TextView

    lateinit var but1: Button
    lateinit var but2: Button
    lateinit var but3: Button
    lateinit var but4: Button

    lateinit var butha1: Button
    lateinit var butha2: Button
    lateinit var butha3: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food1)

        iv1 = findViewById(R.id.ivMenu1)
        iv2 = findViewById(R.id.ivMenu2)
        iv3 = findViewById(R.id.ivMenu3)

        but1 = findViewById(R.id.but1)
        but2 = findViewById(R.id.but2)
        but3 = findViewById(R.id.but3)
        but4 = findViewById(R.id.but4)

        butha1 = findViewById(R.id.butha1)
        butha2 = findViewById(R.id.butha2)
        butha3 = findViewById(R.id.butha3)
        var qty1=0
        var qty2=0
        var qty3=0

        tvTot = findViewById(R.id.tvTotal)

        db1 = Firebase.database.reference

        var Total = 0





        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Food1%20Icon%2FFood%201.png?alt=media&token=b78d5ffe-b519-455c-a28f-22c8dc3ddbf9")
            .into(iv1)
        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Food1%20Icon%2FFood2.jpg?alt=media&token=24f7eb93-c0ee-4d0b-9956-f96abb0402a7")
            .into(iv2)
        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Food1%20Icon%2Ffood3.jpg?alt=media&token=c4dc0d05-a57b-49c1-9e90-a1ec4456dbf5")
            .into(iv3)

        but1.setOnClickListener{
            Total+=28000
            qty1+=1
            tvTot.setText(Total.toString())
        }

        but2.setOnClickListener{
            Total+=25000
            qty2+=1
            tvTot.setText(Total.toString())
        }
        but3.setOnClickListener{
            Total+=2500
            qty3+=1
            tvTot.setText(Total.toString())
        }

        butha1.setOnClickListener {
            if(qty1<=0){
                Toast.makeText(this, "Tidak dapat dikurangi", Toast.LENGTH_SHORT).show()
               qty1=0
            }else {
                qty1-=1
                Total -= 28000
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
                Total -= 2500
                tvTot.setText(Total.toString())
            }
        }


        but4.setOnClickListener {
            var transaction = Food1Obj("Paket Nasi Padang + Ati Rempelo",qty1.toString(),"Paket Nasi Padang + Ayam Bakar",qty2.toString(),"Es Teh Manis",qty3.toString(),Total.toString())
            db1.child("Transaction History Padang Sederhana").push().setValue(transaction)
            Total = 0
            tvTot.setText(Total.toString())
            Toast.makeText(this, "Transaction stored to Firebase", Toast.LENGTH_SHORT).show()
        }


    }


}