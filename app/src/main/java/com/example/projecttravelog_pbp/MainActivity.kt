package com.example.projecttravelog_pbp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.Html
import androidx.fragment.app.Fragment
import com.example.projecttravelog_pbp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding:ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigation.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.post -> replaceFragment(Post())
                R.id.profile -> replaceFragment(Profile())

                else ->{

                }
            }

            true
        }

        // Configure Action Bar Color and Title
        supportActionBar!!.setBackgroundDrawable((ColorDrawable(Color.WHITE)))
        supportActionBar!!.title = Html.fromHtml("<font color=\"black\">"+getString(R.string.app_name)+"</font>")
    }
    
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}
