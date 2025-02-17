package com.example.tarea3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSendMessage = findViewById<Button>(R.id.btnSendMessage)
        val btnTakePhoto = findViewById<Button>(R.id.btnTakePhoto)
        val btnShare = findViewById<Button>(R.id.btnShare)

        btnSendMessage.setOnClickListener {
            val intent = Intent(this, SendMessageActivity::class.java)
            startActivity(intent)
        }

        btnTakePhoto.setOnClickListener {
            val intent = Intent(this, TakePhotoActivity::class.java)
            startActivity(intent)
        }

        btnShare.setOnClickListener {
            val intent = Intent(this, ShareActivity::class.java)
            startActivity(intent)
        }
    }
}