package com.example.zapir.kotlintranslator.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.zapir.kotlintranslator.R
import com.example.zapir.kotlintranslator.utils.inTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var fragment: Fragment
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                fragment = TranslatorFragment()
                supportFragmentManager.inTransaction( { add(R.id.flContent, fragment) })
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //default fragment
        fragment = TranslatorFragment()
        supportFragmentManager.inTransaction( { add(R.id.flContent, fragment) })
        //NavBottom listener
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

}
