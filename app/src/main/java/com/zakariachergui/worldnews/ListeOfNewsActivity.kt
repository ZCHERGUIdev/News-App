package com.zakariachergui.worldnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.recyclerview.widget.LinearLayoutManager
import com.zakariachergui.worldnews.NewsAdapters.ListofNewsAdaper
import com.zakariachergui.worldnews.NewsModels.ListeofNEws
import com.zakariachergui.worldnews.fragmentsNews.HomeViewModel
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_liste_of_news.*
import okhttp3.*
import java.io.IOException
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class ListeOfNewsActivity : AppCompatActivity() {
    lateinit var mAdView : AdView

    companion object {
        fun newInstance() = ListeOfNewsActivity()
    }
    private fun fetchGeson(url: String, namechanell: String) {

        try {
            val Req = Request.Builder().url(url)
                .addHeader(
                    Zcconfig.Api_Key,
                    Zcconfig.Zc_config_Api_val
                ).build()
            val client = OkHttpClient()
            client.newCall(Req).enqueue(object : Callback {
                // using Okhttp
                override fun onFailure(call: Call, e: IOException) {
                    println("Failure " + e.message.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    println( response.body()?.string())
                    val gson = GsonBuilder().create()
                    val news = gson.fromJson( response.body()?.string(), ListeofNEws::class.java)
                    runOnUiThread {
                        textlatestnews.text = "Top headlines from "+namechanell + " (" + news.articles!!.size + ")"
                        recyclerNEws_item.adapter = ListofNewsAdaper(news)
                        recyclerNEws_item.adapter!!.notifyDataSetChanged()
                    }
                }
            })
        } catch (e: Exception) { } finally { }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_of_news)
        MobileAds.initialize(this,"ca-app-pub-7900236362556707~7903292906")
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        recyclerNEws_item.layoutManager = LinearLayoutManager(this)
        val intent = intent
        var id = intent.getStringExtra(HomeViewModel.news_id)
        var name = intent.getStringExtra(HomeViewModel.news_name)

        var namechanell: String = Html.fromHtml(name).toString()
        fetchGeson(Zcconfig.serverurlSourceTop + id, namechanell)


    }
}
