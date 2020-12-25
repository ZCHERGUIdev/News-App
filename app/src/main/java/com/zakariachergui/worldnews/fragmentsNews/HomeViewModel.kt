package com.zakariachergui.worldnews.fragmentsNews

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.worldnews.ListeOfNewsActivity
import com.zakariachergui.worldnews.NewsModels.SourcesItem
import com.zakariachergui.worldnews.R

class HomeViewModel(itemView:View) : RecyclerView.ViewHolder(itemView) {
    var news: SourcesItem?=null
    var  news_img:ImageView=itemView.findViewById<View>(R.id.news_img)  as ImageView
    var sourcenewsname:TextView=itemView.findViewById<View>(R.id.sourcenewsname) as TextView


    companion object {
        var news_id = "id"
        var news_name = "name"
    }
    init {
        itemView.setOnClickListener {
           var myintent=Intent(itemView.context,
               ListeOfNewsActivity::class.java)
            myintent.putExtra(news_id,news!!.id)
            myintent.putExtra(news_name,news!!.name)
            itemView.context.startActivity(myintent)
        }
    }






}


