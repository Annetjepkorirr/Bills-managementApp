package com.example.billsmanagement.ui

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.billsmanagement.R
import com.example.billsmanagement.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        setupBottomNav()
    }

    fun setupBottomNav(){
        binding.bnvHome.setOnItemSelectedListener { menu->
            when(menu.itemId){
                R.id.summary->{
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.Fcv,SummaryFragments())
                        .commit()
                    true
                }
                R.id.upcoming-> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.Fcv, UpcomingFragment())
                        .commit()
                    true

                }
                R.id.paid-> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.Fcv, PaidFragments())
                        .commit()
                    true
                }
                R.id.settings-> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.Fcv, SettingsFragments())
                        .commit()
                    true
                }
                else->{
                    false
                }
            }
        }

    }

}