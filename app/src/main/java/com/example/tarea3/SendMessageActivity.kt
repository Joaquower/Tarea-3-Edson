package com.example.tarea3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SendMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_message)

        val etMessage = findViewById<EditText>(R.id.etMessage)
        val btnSend = findViewById<Button>(R.id.btnSend)

        btnSend.setOnClickListener {
            val message = etMessage.text.toString()
            if (message.isNotEmpty()) {
                sendWhatsAppMessage(message)
            } else {
                Toast.makeText(this, "Por favor, escribe un mensaje", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun sendWhatsAppMessage(message: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://wa.me/?text=" + Uri.encode(message))
                setPackage("com.whatsapp") // Especificamos que queremos abrir WhatsApp
            }
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "WhatsApp no está instalado", Toast.LENGTH_SHORT).show()
        }
    }
}