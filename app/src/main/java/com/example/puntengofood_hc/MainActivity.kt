package com.example.puntengofood_hc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    lateinit var cv1:CardView
    lateinit var cv2:CardView
    lateinit var cv3:CardView
    lateinit var cv4:CardView
    lateinit var cv5:CardView

    lateinit var iv1:ImageView
    lateinit var iv2:ImageView
    lateinit var iv3:ImageView
    lateinit var iv4:ImageView
    lateinit var iv5:ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_resto)

        cv1 = findViewById(R.id.cv1)
        cv2 = findViewById(R.id.cv2)
        cv3 = findViewById(R.id.cv3)
        cv4 =findViewById(R.id.cv4)
        cv5 =findViewById(R.id.cv5)

        iv1 = findViewById(R.id.ivResto1)
        iv2 = findViewById(R.id.ivResto2)
        iv3 = findViewById(R.id.ivResto3)
        iv4 = findViewById(R.id.ivResto4)
        iv5 = findViewById(R.id.ivResto5)


        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Resto%20Icon%2Fresto1.jpg?alt=media&token=d3794624-2d6c-414f-aa45-f6b44b902b63")
            .into(iv1)
        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Resto%20Icon%2Fresto2.jpg?alt=media&token=c5a576af-508b-4cef-a41e-94dbc50daf2d")
            .into(iv2)
        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Resto%20Icon%2Fresto3.jpg?alt=media&token=2ce243ab-c1ef-4223-97c3-8c832524d753")
            .into(iv3)
        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Resto%20Icon%2Fresto4.jpg?alt=media&token=9b19415c-a2ee-424b-87c1-1f837f2e85ec")
            .into(iv4)
        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/gofood-d1f73.appspot.com/o/Resto%20Icon%2Fresto5.jpg?alt=media&token=86b477ef-49c0-40ad-9eaf-3a613c9d4e0c")
            .into(iv5)


        cv1.setOnClickListener{
            val intent1 = Intent(this,Food1Activity::class.java)
            startActivity(intent1)
        }

        cv2.setOnClickListener{
            val intent2 = Intent(this,Food2Activity::class.java)
            startActivity(intent2)
        }

        cv3.setOnClickListener{
            val intent3 = Intent(this,Food3Activity::class.java)
            startActivity(intent3)
        }

        cv4.setOnClickListener{
            val intent4 = Intent(this,Food4Activity::class.java)
            startActivity(intent4)
        }

        cv5.setOnClickListener{
            val intent5 = Intent(this,Food5Activity::class.java)
            startActivity(intent5)
        }

    }
}