package com.undeniabledreams.togather_again.main.view

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.widget.*
import com.undeniabledreams.togather_again.R
import com.undeniabledreams.togather_again.main.dao.UserRegistrationDao
import com.undeniabledreams.togather_again.main.dto.ParentDto
import com.undeniabledreams.togather_again.main.dto.UserDto
import com.undeniabledreams.togather_again.main.list.RelationshipStatusList
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class AddActivity : AppCompatActivity() {

    private lateinit var relationshipTxt: TextView

    private fun showDialogBox(message: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_relationship_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val listView: ListView = dialog.findViewById(R.id.relationship_list_view)
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, RelationshipStatusList.statuses)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            relationshipTxt.text = RelationshipStatusList.statuses[position]
            dialog.dismiss()
        }

        listView.adapter = adapter

        dialog.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed() // Handle back button click
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Retrieve the email address
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "")

        relationshipTxt = findViewById(R.id.relationship_txt)

        val addBtn: Button = findViewById(R.id.add_btn)
        val dialogBtn: Button = findViewById(R.id.dialog_btn)

        dialogBtn.setOnClickListener {
            val message: String = "Select your relationship"
            showDialogBox(message)
        }

        addBtn.setOnClickListener {
            val firstName: String =
                findViewById<EditText>(R.id.add_text_parent_first_name).text.toString()
            val middleName: String =
                findViewById<EditText>(R.id.add_text_parent_middle_name).text.toString()
            val lastName: String =
                findViewById<EditText>(R.id.add_text_parent_last_name).text.toString()
            val age: Int =
                findViewById<EditText>(R.id.add_text_parent_age).text.toString().toIntOrNull() ?: 0
            //date formatter
            val inputDateText =
                findViewById<EditText>(R.id.add_text_parent_last_interaction).text.toString()
            val pattern = "yyyy-MM-dd" // Adjust the pattern according to your input format
            val sdf = SimpleDateFormat(pattern)
            val lastInteraction: Date = sdf.parse(inputDateText)

            val totalInteraction: Int =
                findViewById<EditText>(R.id.add_text_parent_total_interaction).text.toString()
                    .toIntOrNull() ?: 0
//            val relationship : String = findViewById<EditText>(R.id.add_text_parent_relationship).text.toString()



            val note: String = findViewById<EditText>(R.id.add_text_parent_notes).text.toString()


//            try {
//                val parentDto = ParentDto(firstName, middleName, lastName, age, lastInteraction, totalInteraction, relationship, note)
//                val userRegistrationDao = UserRegistrationDao(this)
////                userRegistrationDao.insertIntoUser(userDto)
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }

        }
    }




}