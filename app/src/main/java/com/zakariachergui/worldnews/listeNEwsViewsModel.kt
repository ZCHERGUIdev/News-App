package com.zakariachergui.worldnews

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.worldnews.NewsModels.ArticlesItem

class listeNEwsViewsModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var news: ArticlesItem? = null
    var articleimage: ImageView = itemView.findViewById<View>(R.id.postThumbnail) as ImageView
    var articlename: TextView = itemView.findViewById<View>(R.id.postTitle) as TextView
    var articletime: TextView = itemView.findViewById<View>(R.id.metaTitle) as TextView

    companion object {
        var UrlPost = "Url_News"
    }

    init {
        itemView.setOnClickListener {
            var myintent = Intent(itemView.context, DetailsNEws::class.java)
            myintent.putExtra("UrlPost", news!!.url)
            itemView.context.startActivity(myintent)

        }
    }


}