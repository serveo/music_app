package com.example.interactable_app

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.interactable_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.song.setOnClickListener(){
            val intent = Intent(this, song::class.java)
            startActivity(intent)
        }
        binding.webButton.setOnClickListener {
            val intent = Intent(this, web::class.java)
            startActivity(intent)
        }
        binding.viedeoButtonn.setOnClickListener{
            val intent = Intent(this,Video::class.java)
            startActivity(intent)
        }


           }
}