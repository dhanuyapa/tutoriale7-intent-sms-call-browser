package com.example.tutorial7

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class HomeActivity : AppCompatActivity() {

    lateinit var imageView: ImageView

    private val thumbnailLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val imageBitmap = data?.extras?.get("data") as? Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        imageView = findViewById(R.id.imageView)

        button2.setOnClickListener {
            // Explicit intent
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            //finish() direct back
        }

        button3.setOnClickListener {
            // Implicit intent to open the dialer with a number

            val number = "+94779180997"
            val uri = Uri.parse("tel:$number")
            val intent = Intent(Intent.ACTION_DIAL, uri)

            startActivity(intent)
        }

        button4.setOnClickListener {
            // Add functionality for button4
            val number = "+94779180997"
            val smsText = "Welcome to MAD 2023"
            val uri = Uri.parse(String.format("smsto:$number"))
            val intent = Intent()
            intent.action = Intent.ACTION_SENDTO
            intent.data = uri
            intent.putExtra("sms_body", smsText)
            startActivity(intent)
        }

        button5.setOnClickListener {
            // Add functionality for button5
            // Replace "https://example.com" with your actual URL
            val url = "https://rjt.ac.lk"

            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        }

        button6.setOnClickListener {
            // Add functionality for button6

            val mailTo = arrayOf("dhanuyapaugc@email.com")
            val subject = "Test Email"
            val mailBody = "This the test email body"
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, mailTo)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, mailBody)
            startActivity(intent)
        }

        button7.setOnClickListener {
            // Add functionality for button7
            val intent = Intent()
            intent.action = MediaStore.ACTION_IMAGE_CAPTURE
            thumbnailLauncher.launch(intent)
        }
    }
}

