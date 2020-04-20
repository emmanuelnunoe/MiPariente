package com.example.mipaciente

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_db_test.*

class dbTest : AppCompatActivity() {

    lateinit var editTextName: EditText
    lateinit var ratingBar: RatingBar
    lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db_test)

        editTextName = findViewById(R.id.editTextName)
        ratingBar = findViewById(R.id.ratingBar)
        buttonSave = findViewById(R.id.buttonSave)

        buttonSave.setOnClickListener(){
            saveHero()
        }

    }

    private fun saveHero() {
        val name = editTextName.text.toString().trim()

        if(name.isEmpty()){
            editTextName.error = "Please enter a name"
            return
        }


        val ref = FirebaseDatabase.getInstance().getReference("heroes")
        val heroId = ref.push().key

        val hero = heroId?.let { Hero(it, name, ratingBar.numStars) }

        if (heroId != null) {
            ref.child(heroId).setValue(hero).addOnCompleteListener {
                Toast.makeText(applicationContext, "Hero save succesfully", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}


