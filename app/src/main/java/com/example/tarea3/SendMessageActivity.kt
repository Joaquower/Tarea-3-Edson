package com.example.tarea3

import android.content.Intent
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
                shareMessage(message)
            } else {
                Toast.makeText(this, "Por favor, escribe un mensaje", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun shareMessage(message: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"  // Especificamos que el contenido es texto
            putExtra(Intent.EXTRA_TEXT, message)  // Enviamos el mensaje como EXTRA
        }

        val chooser = Intent.createChooser(intent, "Compartir mensaje con:")
        startActivity(chooser) // Muestra la lista de apps disponibles
    }
}