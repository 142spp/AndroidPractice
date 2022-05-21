package com.example.week9_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week9_4.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach

class MainActivity : AppCompatActivity() {
    var time : Int = 0
    var add : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        var binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.activityMain)

        binding.Btnstart.setOnClickListener{
            if(time.equals(0)){
                add = 1
            }
        }
        
        binding.Btnpause.setOnClickListener{
            add = 0
        }
        
        binding.Btnresume.setOnClickListener{
            if(time!=0) {
                add = 1
            }
        }

        binding.Btnstop.setOnClickListener{
            add = 0
            time = 0
        }

        var counter = 0

        val channel = Channel<Int>()
        val backgroundScope = CoroutineScope(Dispatchers.Default + Job())
        backgroundScope.launch {
            time = 0
            for( i in 1..2_000_000_000){
                delay(100)
                counter++
                if(counter%10 ==0){
                    time += add
                }
                channel.send(time.toInt())
            }
        }
        val mainScope = GlobalScope.launch(Dispatchers.Main) {
            channel.consumeEach {
                binding.timer.text = intTotime(time)
            }
        }
    }

    fun intTotime(num : Int) : String{
        var second  : Int = num%60
        var minute : Int = (num/60)%60
        var hour : Int = num/3600
        var timestr = String.format("%02d",hour)+":"+String.format("%02d",minute)+":"+String.format("%02d",second)
        return timestr
    }
}