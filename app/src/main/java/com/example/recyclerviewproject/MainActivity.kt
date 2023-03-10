package com.example.recyclerviewproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var foodArrayList:ArrayList<FastFood>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView=findViewById(R.id.recyclerView)
        val foodImageArray=arrayOf(
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

        val foodNameArray= arrayOf(
            "Bacon", "Burger", "Chips", "Donut", "FriedChicken", "Hotdog",
            "Pancakes", "Pizza", "Popcorn", "Sandwich", "Taco", "Waffles"
        )
        val foodPriceArray= arrayOf(
            "$5","$8","$6","$5","$10","$8","$6",
            "$10","$5","$7","$8","$6"
        )
        val foodRatingArray= arrayOf(
            "4.0","4.8","4.5","4.2","4.3","4.6","4.3",
            "4.4","4.7","4.2","4.4","4.1"
        )
        val foodDescriptionArray=arrayOf( getString(R.string.baconDesc),
            getString(R.string.burgerDesc),
            getString(R.string.chipsDesc),getString(R.string.donutDesc),getString(R.string.friedChickenDesc),
            getString(R.string.hotDogDesc),getString(R.string.pancakesDesc),getString(R.string.pizzaDesc),
            getString(R.string.popcornDesc),getString(R.string.sandwichDesc),getString(R.string.tacoDesc),
            getString(R.string.wafflesDesc)
        )

        myRecyclerView.layoutManager= LinearLayoutManager(this)
        foodArrayList= arrayListOf<FastFood>()
        for(index in foodImageArray.indices){
            val food=FastFood(foodNameArray[index],foodPriceArray[index],foodRatingArray[index],
            foodImageArray[index],foodDescriptionArray[index])
            foodArrayList.add(food)
        }
       val myAdapter=MyAdapter(foodArrayList,this)
        myRecyclerView.adapter=myAdapter
        myAdapter.setOnItemClickListener(object: MyAdapter.onItemClickListener{
            override fun onItemClicking(position: Int) {
                // on clicking each item
                val intent= Intent(this@MainActivity,fastfoodDescription::class.java)
                val name=foodNameArray[position]
                val rating=foodRatingArray[position]
                val price=foodPriceArray[position]
                val imgId=foodImageArray[position]
                val desc=foodDescriptionArray[position]
                intent.putExtra("foodName",name)
                intent.putExtra("foodPrice",price)
                intent.putExtra("foodRating",rating)
                intent.putExtra("foodImage",imgId)
                intent.putExtra("foodDescription",desc)
                startActivity(intent)
            }
        })
    }
}