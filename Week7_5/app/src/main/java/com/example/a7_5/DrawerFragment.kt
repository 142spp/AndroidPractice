package com.example.a7_5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.a7_5.databinding.ActivityMainBinding

class DrawerFragment : Fragment(), View.OnClickListener {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.drawer_layout,container,false)
        toggle = ActionBarDrawerToggle(activity,view.findViewById(R.id.drawer),
            R.string.drawer_opend, R.string.drawer_closed)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
        val fragButton = view.findViewById<Button>(R.id.fragBut1)
        val fragmentManager: FragmentManager = parentFragmentManager
        var onClicked = false
        fragButton.setOnClickListener{
            if(onClicked){
                onClicked = false;
                val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                val frameLayout = fragmentManager.findFragmentById(R.id.fragment_content)
                transaction.remove(frameLayout!!).commit()
            }
            else{
                onClicked=true
                val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                transaction.add(R.id.fragment_content,OneFragment()).commit()
            }
        }
        return inflater.inflate(R.layout.drawer_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
    }
    fun setOnClickListener(){

    }
    override fun onClick(p0: View?) {

    }

}