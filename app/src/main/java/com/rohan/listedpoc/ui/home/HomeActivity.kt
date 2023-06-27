package com.rohan.listedpoc.ui.home

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.rohan.listedpoc.R
import com.rohan.listedpoc.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity: AppCompatActivity() {

    var binding : ActivityHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding?.root)

        binding?.bottomNav?.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.navigation_links->{
                    binding?.navHostFragment?.findNavController()?.navigate(R.id.linksFragment)
                }
                R.id.navigation_courses->{
                    binding?.navHostFragment?.findNavController()?.navigate(R.id.coursesFragment)
                }
                R.id.navigation_campaigns->{
                    binding?.navHostFragment?.findNavController()?.navigate(R.id.campaignsFragment)
                }
                R.id.navigation_profile->{
                    binding?.navHostFragment?.findNavController()?.navigate(R.id.profileFragment)
                }
            }
            true
        }
    }

}