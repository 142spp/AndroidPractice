package com.example.a7_4

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a7_4.databinding.ItemPagerBinding

class MyPagerViewHolder(val binding:ItemPagerBinding):RecyclerView.ViewHolder(binding.root)

class MyPagerAdapter(val datas:MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = MyPagerViewHolder(
        ItemPagerBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("kkang","onBindViewHolder : $position")
        val binding = (holder as MyPagerViewHolder).binding

        binding.itemPagerTextView.text=datas[position]
        when(position %3){
            0 -> binding.itemPagerTextView.setBackgroundColor(Color.RED)
            1 -> binding.itemPagerTextView.setBackgroundColor(Color.BLUE)
            2 -> binding.itemPagerTextView.setBackgroundColor(Color.GREEN)
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}