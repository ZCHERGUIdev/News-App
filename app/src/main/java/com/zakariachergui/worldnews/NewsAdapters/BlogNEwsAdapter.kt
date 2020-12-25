package com.zakariachergui.worldnews.NewsAdapters

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.worldnews.MdaelBlogNEws.BlogNewsBlog
import com.zakariachergui.worldnews.R
import com.zakariachergui.worldnews.fragmentsNews.BlogViewModel
import com.squareup.picasso.Picasso


class BlogNEwsAdapter(val weBsite: BlogNewsBlog): RecyclerView.Adapter<BlogViewModel>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewModel {
        var v= LayoutInflater.from(parent.context).inflate(R.layout.news_row_usa,parent,false)
        return BlogViewModel(v)
    }

    override fun getItemCount(): Int {
        return weBsite.articles!!.size

    }

    override fun onBindViewHolder(holder: BlogViewModel, position: Int) {

        try {
            var news=weBsite.articles!!.get(position)
            holder?.news=news
            if (news.title.length>65)
            {
                holder?.articlename.text= Html.fromHtml(news.title).substring(1..50)+"..."

            }else
            {
                holder?.articlename.text= Html.fromHtml(news.title)

            }
            holder?.articletime.text= Html.fromHtml(news.publishedAt)


            Picasso.with(holder.itemView.context).load(news.urlToImage).into(holder.articleimage)


        }catch (e:Exception){

        } finally {

        }
    }


}
