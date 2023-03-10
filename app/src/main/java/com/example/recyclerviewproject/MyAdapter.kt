package com.example.recyclerviewproject

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(var foodArrayList:ArrayList<FastFood>,var context: Activity)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

   private lateinit var myListener:onItemClickListener
    interface onItemClickListener {
        fun onItemClicking(position:Int)
    }
      fun setOnItemClickListener(listener: onItemClickListener){
          myListener=listener
      }
// to create a new instance when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {

        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
    return MyViewHolder(itemView,myListener)
    }
// to populate items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem=foodArrayList[position]
        holder.foodName.text=currentItem.foodName
    holder.foodPrice.text=currentItem.price
    holder.foodRating.text=currentItem.rating
    holder.foodImage.setImageResource(currentItem.foodImage)
    }

    override fun getItemCount(): Int {
        return foodArrayList.size
    }
    // it holds the views so views are not created everytime,so memory can be saved
    class MyViewHolder(itemView: View, listener: onItemClickListener):RecyclerView.ViewHolder(itemView) {
        val foodName=itemView.findViewById<TextView>(R.id.txt_fastFoodName)
        val foodPrice=itemView.findViewById<TextView>(R.id.txt_price)
        val foodRating=itemView.findViewById<TextView>(R.id.txt_rating)
        val foodImage=itemView.findViewById<CircleImageView>(R.id.img_food)
        init{
           itemView.setOnClickListener{
               listener.onItemClicking(adapterPosition)
           }
        }
    }

}