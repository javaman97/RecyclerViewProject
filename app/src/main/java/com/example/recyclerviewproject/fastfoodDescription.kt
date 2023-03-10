package com.example.recyclerviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class fastfoodDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fastfood_description)
        val food=intent.getStringExtra("foodName")
        val price=intent.getStringExtra("foodPrice")
        val imgId=intent.getIntExtra("foodImage",R.drawable.burger)
        val rating=intent.getStringExtra("foodRating")
        val description=intent.getStringExtra("foodDescription")

        val foodName=findViewById<TextView>(R.id.txt_foodName)
        val Price=findViewById<TextView>(R.id.txt_price)
        val Rating=findViewById<TextView>(R.id.txt_rating)
        val Description=findViewById<TextView>(R.id.txt_desc)
        val foodImg=findViewById<CircleImageView>(R.id.img_food)
        foodName.text=food
        Price.text=price
        Rating.text=rating
        Description.text=description
        foodImg.setImageResource(imgId)
    }
}