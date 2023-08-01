package com.undeniabledreams.togather_again.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.undeniabledreams.togather_again.R
import com.undeniabledreams.togather_again.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(FamilyFragment())

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