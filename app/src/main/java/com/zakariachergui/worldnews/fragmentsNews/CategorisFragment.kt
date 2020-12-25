package com.zakariachergui.worldnews.fragmentsNews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.worldnews.NewsAdapters.UsanewsAdapter

import com.zakariachergui.worldnews.R
import com.zakariachergui.worldnews.Zcconfig
import com.zakariachergui.worldnews.modalusanews.Usanews
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.categoris_fragment.*
import kotlinx.android.synthetic.main.home_fragment.recyclerview_item
import okhttp3.*
import java.io.IOException
import java.lang.StringBuilder
import kotlin.concurrent.thread

class CategorisFragment : Fragment() {

    companion object {
        fun newInstance() =
            CategorisFragment()
    }

    private lateinit var viewModel: CategorisViewModel
    lateinit var mAdView : AdView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rotView= inflater.inflate(R.layout.categoris_fragment, container, false)
        val rv=rotView.findViewById<View>(R.id.recyclerview_item) as RecyclerView
        rv.layoutManager= LinearLayoutManager(newInstance().context)
      //  MobileAds.initialize(CategorisFragment.newInstance().context,"ca-app-pub-7900236362556707~7903292906")
        mAdView = rotView.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        return rotView
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        fetchGeson()
        super.onCreate(savedInstanceState)
    }





    private fun fetchGeson() {
        try{

            val Req= Request.Builder().url(Zcconfig.serverurlSourceTopusa)
                .addHeader(Zcconfig.Api_Key, Zcconfig.Zc_config_Api_val).build()
            val client= OkHttpClient()
            client.newCall(Req).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    println("Failure "+e.message.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    val body= response.body()?.string()
                    println(body)
                    val gson= GsonBuilder().create()
                    val news =gson.fromJson(body, Usanews::class.java)

                    if (activity!=null)
                    {
                        thread {
                            activity!!.runOnUiThread { recyclerview_item.adapter=
                                UsanewsAdapter(
                                    news
                                )
                                textnews.text=StringBuilder("Top headlines in the US (").append(news.articles!!.size).append(")")
                                recyclerview_item.adapter!!.notifyDataSetChanged()
                            }
                        }
                    }

                }

            })
        }catch (e:Exception){

        }finally {

        }


    }

}
