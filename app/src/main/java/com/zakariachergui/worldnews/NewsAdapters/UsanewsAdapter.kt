package com.zakariachergui.worldnews.NewsAdapters

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.worldnews.R
import com.zakariachergui.worldnews.fragmentsNews.CategorisViewModel
import com.zakariachergui.worldnews.modalusanews.Usanews
import com.squareup.picasso.Picasso


class UsanewsAdapter(val weBsite: Usanews): RecyclerView.Adapter<CategorisViewModel>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorisViewModel {
        var v= LayoutInflater.from(parent.context).inflate(R.layout.news_row_usa,parent,false)
        return CategorisViewModel(v)
    }

    override fun getItemCount(): Int {
        return weBsite.articles!!.size

    }

    override fun onBindViewHolder(holder: CategorisViewModel, position: Int) {

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
