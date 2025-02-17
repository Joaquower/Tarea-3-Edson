package com.example.tarea3
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class ShareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        val tvSharedText = findViewById<TextView>(R.id.tvSharedText)

        // Verifica si la actividad fue iniciada por un "compartir"
        if (intent?.action == Intent.ACTION_SEND && intent.type == "text/plain") {
            val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)
            tvSharedText.text = sharedText
        }
    }
}