package com.zakariachergui.worldnews.NewsAdapters

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.worldnews.NewsModels.ListeofNEws
import com.zakariachergui.worldnews.R
import com.zakariachergui.worldnews.listeNEwsViewsModel
import com.squareup.picasso.Picasso


class ListofNewsAdaper(val listNews: ListeofNEws): RecyclerView.Adapter<listeNEwsViewsModel>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listeNEwsViewsModel {

        val contex:Context
        var v= LayoutInflater.from(parent.context).inflate(R.layout.news_row,parent,false)
        return listeNEwsViewsModel(v)
    }

    override fun getItemCount(): Int {
      return  listNews.articles!!.size
    }

    override fun onBindViewHolder(holder: listeNEwsViewsModel, position: Int) {
           var contx:Context

        try {
            var news=listNews.articles!!.get(position)
            holder?.news=news


            if (news.title.length>65)
            {
                holder?.articlename.text= Html.fromHtml(news.title).substring(1..60)+"..."

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