package com.zakariachergui.worldnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_details_news.*

class DetailsNEwsUsa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_news_usa)

        webView.settings.javaScriptEnabled=true
        webView.webChromeClient= WebChromeClient()
        webView.webViewClient=object : WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }
        if (intent!=null)
        {
            if (!intent.getStringExtra("UrlPost").isEmpty())
            {
                webView.loadUrl(intent.getStringExtra("UrlPost"))
            }
        }
    }

}

