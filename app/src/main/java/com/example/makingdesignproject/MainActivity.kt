package com.example.makingdesignproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var user_name_field: EditText
    private lateinit var user_bio_field: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user_name_field = findViewById(R.id.user_name_field)
        user_bio_field = findViewById(R.id.user_bio_field)
    }
    fun saveData(view: View){
        val user_name : String = user_name_field.text.toString()
        val user_bio : String = user_bio_field.text.toString()

        val fileOutput: FileOutputStream = openFileOutput("user_data.txt", MODE_PRIVATE)
        fileOutput.write(("$user_name.  $user_bio").toInt())
        fileOutput.close()

        user_name_field.setText("")
        user_bio_field.setText("")
        Toast.makeText(this, "Text is saved!", Toast.LENGTH_SHORT).show()
    }
    fun getData(view: View){
        var fileInput: FileInputStream = openFileInput("user_data.txt")
        var reader: InputStreamReader = InputStreamReader(fileInput)
        var bR: BufferedReader = BufferedReader(reader)

        var stringBuffer: StringBuilder = StringBuilder()
        var lines: String = ""
//        var result: String = ""
        while (bR.readLine()!= null){
            stringBuffer.append(lines).append("\n")
        }
        Toast.makeText(this, stringBuffer, Toast.LENGTH_SHORT).show()
    }

    fun goContacts(view: View){
        val intent = Intent(this, ContactsActivity::class.java)
        startActivity(intent)

    }
    fun goWeb(view: View){
        val intent = Intent(this, WebActivity::class.java)
        startActivity(intent)

    }
}

//private fun FileOutputStream.write(toByte: Byte) {
//
//}
