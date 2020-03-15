package com.example.spotifyswipe
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //private lateinit var textMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // textMessage = findViewById(R.id.message)

        button3.setOnClickListener{
            val intent = Intent(this, SpotiftSwipePageActivity::class.java)
            startActivity(intent)
        }

    }
}
