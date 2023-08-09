package com.undeniabledreams.togather_again.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.undeniabledreams.togather_again.R
import com.undeniabledreams.togather_again.main.dao.UserRegistrationDao
import com.undeniabledreams.togather_again.main.dto.ParentDto
import com.undeniabledreams.togather_again.main.dto.UserDto
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        // Retrieve the email address
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "")

        val addBtn: Button = findViewById(R.id.add_btn)

        addBtn.setOnClickListener{
            val firstName : String = findViewById<EditText>(R.id.add_text_parent_first_name).text.toString()
            val middleName : String = findViewById<EditText>(R.id.add_text_parent_middle_name).text.toString()
            val lastName : String = findViewById<EditText>(R.id.add_text_parent_last_name).text.toString()
            val age: Int = findViewById<EditText>(R.id.add_text_parent_age).text.toString().toIntOrNull() ?: 0
            //date formatter
            val inputDateText = findViewById<EditText>(R.id.add_text_parent_last_interaction).text.toString()
            val pattern = "yyyy-MM-dd" // Adjust the pattern according to your input format
            val sdf = SimpleDateFormat(pattern)
            val lastInteraction: Date = sdf.parse(inputDateText)

            val totalInteraction : Int = findViewById<EditText>(R.id.add_text_parent_total_interaction).text.toString().toIntOrNull() ?: 0
            val relationship : String = findViewById<EditText>(R.id.add_text_parent_relationship).text.toString()
            val note : String = findViewById<EditText>(R.id.add_text_parent_notes).text.toString()


            try {
                val parentDto = ParentDto(firstName, middleName, lastName, age, lastInteraction, totalInteraction, relationship, note)
                val userRegistrationDao = UserRegistrationDao(this)
//                userRegistrationDao.insertIntoUser(userDto)
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }


    }
}