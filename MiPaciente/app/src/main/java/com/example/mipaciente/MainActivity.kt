package com.example.mipaciente

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_main)

    }

    fun main()
    {
        println("Mi paciente")
    }

    // called when users click the button
    fun searchButton(view: View) {
        // Do something in response to button
        val intent = Intent(this, dbTest::class.java)
        startActivity(intent)

    }
}
