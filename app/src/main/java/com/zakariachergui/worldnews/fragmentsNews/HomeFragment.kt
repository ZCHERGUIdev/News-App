package com.zakariachergui.worldnews.fragmentsNews

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.View.inflate
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.worldnews.NewsAdapters.HomeAdapter
import com.zakariachergui.worldnews.NewsModels.Lastestnews
import com.zakariachergui.worldnews.R
import com.zakariachergui.worldnews.Zcconfig
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.home_fragment.*
import okhttp3.*
import java.io.IOException
import kotlin.concurrent.thread


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    lateinit var mAdView : AdView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val rotView= inflater.inflate(R.layout.home_fragment, container, false)
        val rv=rotView.findViewById<View>(R.id.recyclerview_item) as RecyclerView
        rv.layoutManager=LinearLayoutManager(newInstance().context)
        mAdView = rotView.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        return rotView
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchGeson()

        /*
        override fun onCreateOptionsMenu(menu: Menu): Boolean {

            menuInflater.inflate(R.menu.menu, menu)

            val sv: SearchView = menu.findItem(R.id.app_bar_search).actionView as SearchView

            val sm= getSystemService(Context.SEARCH_SERVICE) as SearchManager
            sv.setSearchableInfo(sm.getSearchableInfo(componentName))
            sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    Toast.makeText(newInstance().context, query, Toast.LENGTH_LONG).show()
                    recyclerview_item.adapter
                    return false
                }
                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
            })

            return super.onCreateOptionsMenu(menu)
        }*/


    }

    private fun fetchGeson() {
        try{
            val Req= Request.Builder().url(Zcconfig.serverurlsource)
                .addHeader(
                    Zcconfig.Api_Key,
                    Zcconfig.Zc_config_Api_val).build()
            val client= OkHttpClient()

            client.newCall(Req).enqueue(object : Callback {

                override fun onFailure(call: Call, e: IOException) {
                    println("Failure "+e.message.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    val body= response.body()?.string()
                    println(body)
                    val gson=GsonBuilder().create()
                    val news =gson.fromJson(body,Lastestnews::class.java)
                    if (activity!=null)
                    {
                        thread {

                       activity!!.runOnUiThread {
                           recyclerview_item.adapter=
                               HomeAdapter(news)
                           textlatestnews.text="All sources available ("+news.sources!!.size+")"
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
