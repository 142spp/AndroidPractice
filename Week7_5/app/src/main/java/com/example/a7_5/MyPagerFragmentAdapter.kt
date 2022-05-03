package com.example.a7_5

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerFragmentAdapter(activity: FragmentActivity) :FragmentStateAdapter(activity){

    var fragments : ArrayList<Fragment> = arrayListOf(DrawerFragment(),RecyclerFragment())

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }


}