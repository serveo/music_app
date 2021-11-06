package com.example.interactable_app

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient




class web : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        webView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://www.universalmusic.com/")

        webView.settings.javaScriptEnabled = true

        webView.settings.setSupportZoom(true)
    }


    override fun onBackPressed() {

        if (webView.canGoBack())
            webView.goBack()
        else
            super.onBackPressed()
    }
}

