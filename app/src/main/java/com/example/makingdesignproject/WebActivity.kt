package com.example.makingdesignproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        var webView: WebView = findViewById(R.id.webView)
        var webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.loadUrl("https://youtube.com")
        webView.webViewClient = WebViewClient()

    }
    fun goHome(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
    fun goContacts(view: View){
        val intent = Intent(this, ContactsActivity::class.java)
        startActivity(intent)

    }
}