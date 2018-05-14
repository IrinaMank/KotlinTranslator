package com.example.zapir.kotlintranslator.utils

import android.support.v4.app.FragmentTransaction

//Fragments Transactions
inline fun android.support.v4.app.FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}