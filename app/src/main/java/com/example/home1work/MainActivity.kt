package com.example.home1work

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            image.setImageURI(uri)
        }
    private lateinit var button: Button
    private lateinit var image: ImageView
    private lateinit var etText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = this.findViewById(R.id.mb_button)
        etText = this.findViewById(R.id.tv_text)

        goToWhatsapp()
    }

    private fun goToWhatsapp() {
        button.setOnClickListener {
            val tvNumber = etText.text.toString().trim()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$tvNumber")
            startActivity(intent)
        }
        image.setOnClickListener {
            openGallery()
        }
    }
    private fun openGallery() {
        getContent.launch("image/*")
    }
}
