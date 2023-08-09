package com.undeniabledreams.togather_again.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.undeniabledreams.togather_again.R
import com.undeniabledreams.togather_again.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(FamilyFragment())

        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener {
            // Start your desired activity here
            val intent = Intent(this@MainActivity, AddActivity::class.java)
            startActivity(intent)
        }

        binding.bottomNavView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.family -> replaceFragment(FamilyFragment())
                R.id.interactions -> replaceFragment(InteractionsFragment())
                R.id.album -> replaceFragment(AlbumFragment())

                else -> {

                }
            }
            true
        }

    }



    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

}