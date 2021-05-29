package com.example.puntengofood_hc

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference

class Food4Activity:AppCompatActivity() {
    lateinit var iv1: ImageView
    lateinit var iv2: ImageView
    lateinit var iv3: ImageView
    lateinit var iv4: ImageView

    lateinit var but1: Button
    lateinit var but2: Button
    lateinit var but3: Button
    lateinit var but4: Button
    lateinit var but5: Button

    lateinit var butha1: Button
    lateinit var butha2: Button
    lateinit var butha3: Button
    lateinit var butha5: Button

    lateinit var db1: DatabaseReference
    lateinit var tvTot: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food4)

        iv1 = findViewById(R.id.ivMenu1)
        iv2 = findViewById(R.id.ivMenu2)
        iv3 = findViewById(R.id.ivMenu3)
        iv4 = findViewById(R.id.ivMenu4)

        but1 = findViewById(R.id.but1)
        but2 = findViewById(R.id.but2)
        but3 = findViewById(R.id.but3)
        but4 = findViewById(R.id.but4)
        but5 = findViewById(R.id.but5)

        butha1 = findViewById(R.id.butha1)
        butha2 = findViewById(R.id.butha2)
        butha3 = findViewById(R.id.butha3)
        butha5 = findViewById(R.id.butha5)
        var qty1=0
        var qty2=0
        var qty3=0
        var qty5=0

        tvTot = findViewById(R.id.tvTotal)

        var Total = 0

        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Food4%20icon%2Fbatagor1.jpg?alt=media&token=cbe66a5d-57cd-4567-8e4b-4cf5d6361298")
                .into(iv1)
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Food4%20icon%2Fcireng3.jpg?alt=media&token=ba0f12ee-48bc-4be8-9874-53c010aebb32")
                .into(iv2)
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Food4%20icon%2Fpentol2%20goreng.jpg?alt=media&token=8f20aa1a-3d07-46e6-b5a1-bf80c39e1c51")
                .into(iv3)
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Food4%20icon%2Fjeruk5.jpg?alt=media&token=836ea5ee-8742-4b26-adc8-79b06c8abd0a")
                .into(iv4)

        but1.setOnClickListener{
            Total+=15000
            qty1+=1
            tvTot.setText(Total.toString())
        }

        but2.setOnClickListener{
            Total+=12000
            qty2+=1
            tvTot.setText(Total.toString())
        }
        but3.setOnClickListener{
            Total+=10000
            qty3+=1
            tvTot.setText(Total.toString())
        }

        but5.setOnClickListener{
            Total+=3000
            qty5+=1
            tvTot.setText(Total.toString())
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
                Total -= 12000
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

        butha5.setOnClickListener {
            if(qty5<=0){
                Toast.makeText(this, "Tidak dapat dikurangi", Toast.LENGTH_SHORT).show()
                qty5=0
            }else {
                qty5-=1
                Total -= 3000
                tvTot.setText(Total.toString())
            }
        }


        but4.setOnClickListener {
            var transaction = Food1Obj("Pentol Gobyos",Total.toString())
            db1.child("Transaction History Resto 4").push().setValue(transaction)
            Total = 0
            tvTot.setText(Total.toString())
            Toast.makeText(this, "Transaction stored to Firebase", Toast.LENGTH_SHORT).show()
        }



    }
}