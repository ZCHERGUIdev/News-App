package com.zakariachergui.worldnews.fragmentsNews

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.worldnews.DetailsNEws
import com.zakariachergui.worldnews.R
import com.zakariachergui.worldnews.modalusanews.ArticlesItemUsa

class CategorisViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var news: ArticlesItemUsa? = null
    var  articleimage: ImageView =itemView.findViewById<View>(R.id.postThumbnail)  as ImageView
    var articlename: TextView =itemView.findViewById<View>(R.id.postTitle) as TextView
    var articletime: TextView =itemView.findViewById<View>(R.id.metaTitle) as TextView



    init {
        itemView.setOnClickListener {
            var myintent=Intent(itemView.context, DetailsNEws::class.java)
            myintent.putExtra("UrlPost",news!!.url)
            itemView.context.startActivity(myintent)
        }
    }
}
