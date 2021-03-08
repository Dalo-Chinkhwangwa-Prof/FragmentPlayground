package com.britishbroadcast.myfragapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {


    private val exampleFragment = ExampleFragment()
    private val secondFragment = FragmentB()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Handler(Looper.getMainLooper()).postDelayed({


            supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.main_framelayout, exampleFragment.also {
                        val bundle = Bundle().also {
                            it.putString("KEY", "See it works")
                        }
                        it.arguments = bundle

                    })
                    .addToBackStack(exampleFragment.tag)
                    .commit()


            supportFragmentManager.beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left)
                    .add(R.id.second_framelayout, secondFragment)
                    .addToBackStack(secondFragment.tag)
                    .commit()


        }, 3000)

    }
}