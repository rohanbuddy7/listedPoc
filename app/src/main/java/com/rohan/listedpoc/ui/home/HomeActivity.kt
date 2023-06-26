package com.rohan.listedpoc.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.rohan.listedpoc.R.layout.activity_home)

        val bottomNavigationView = findViewById<BottomNavigationView>(com.rohan.listedpoc.R.id.bottom_nav)


    }

}