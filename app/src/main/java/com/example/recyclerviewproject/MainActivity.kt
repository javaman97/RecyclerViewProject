package com.example.recyclerviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewproject.model.fastfood

class MainActivity : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var foodArrayList:ArrayList<fastfood>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView=findViewById(R.id.recyclerView)
        var foodImageArray=arrayOf(
            R.drawable.bacon,
            R.drawable.burger,
            R.drawable.chips,
            R.drawable.donut,
            R.drawable.friedchicken,
            R.drawable.hotdog,
            R.drawable.pancakes,
            R.drawable.pizza,
            R.drawable.popcorn,
            R.drawable.sandwich,
            R.drawable.taco,
            R.drawable.waffles
        )

        var foodNameArray= arrayOf(
            "Bacon", "Burger", "Chips", "Donut", "FriedChicken", "Hotdog",
            "Pancakes", "Pizza", "Popcorn", "Sandwich", "Taco", "Waffles"
        )
        var foodPriceArray= arrayOf(
            "$5","$8","$6","$5","$10","$8","$6",
            "$10","$5","$7","$8","$6"
        )
        var foodRatingArray= arrayOf(
            "4.0","4.8","4.5","4.2","4.3","4.6","4.3",
            "4.4","4.7","4.2","4.4","4.1"
        )

        myRecyclerView.layoutManager= LinearLayoutManager(this)
        foodArrayList= arrayListOf<fastfood>()
        for(index in foodImageArray.indices){
            val food=fastfood(foodNameArray[index],foodPriceArray[index],foodRatingArray[index],
            foodImageArray[index])
            foodArrayList.add(food)
        }

        myRecyclerView.adapter=MyAdapter(foodArrayList,this)
    }
}