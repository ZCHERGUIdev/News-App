package com.zakariachergui.worldnews.fragmentsNews

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.worldnews.MdaelBlogNEws.ArticlesItemBlog
import com.zakariachergui.worldnews.R

class BlogViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var news: ArticlesItemBlog? = null
    var  articleimage: ImageView =itemView.findViewById<View>(R.id.postThumbnail)  as ImageView
    var articlename: TextView =itemView.findViewById<View>(R.id.postTitle) as TextView
    var articletime: TextView =itemView.findViewById<View>(R.id.metaTitle) as TextView



    init {
        itemView.setOnClickListener {
        }
    }
}