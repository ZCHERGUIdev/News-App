package com.zakariachergui.worldnews.fragmentsNews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.worldnews.NewsAdapters.BlogNEwsAdapter
import com.zakariachergui.worldnews.MdaelBlogNEws.BlogNewsBlog
import com.zakariachergui.worldnews.R
import com.zakariachergui.worldnews.Zcconfig
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.categoris_fragment.*
import kotlinx.android.synthetic.main.home_fragment.recyclerview_item
import okhttp3.*
import java.io.IOException
import kotlin.concurrent.thread

class BlogFragment : Fragment() {

    companion object {
        fun newInstance() = BlogFragment()
    }

    private lateinit var viewModel: BlogViewModel
    lateinit var mAdView : AdView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            val rotView= inflater.inflate(R.layout.blog_fragment, container, false)
            val rv=rotView.findViewById<View>(R.id.recyclerview_item) as RecyclerView
            rv.layoutManager= LinearLayoutManager(newInstance().context)
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

            val Req= Request.Builder().url(Zcconfig.serverblogger)
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
                    val news =gson.fromJson(body, BlogNewsBlog::class.java)

                    if (activity!=null)
                    {
                        thread {
                            activity!!.runOnUiThread {
                                //All articles published by the WSJ and NY Times
                                textnews.text="All articles published by the WSJ and NY Times ("+news.articles!!.size+")"
                                recyclerview_item.adapter=
                                    BlogNEwsAdapter(
                                        news
                                    )
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
