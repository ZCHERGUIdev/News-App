package com.zakariachergui.worldnews.NewsAdapters

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zakariachergui.worldnews.NewsModels.Lastestnews
import com.zakariachergui.worldnews.R
import com.zakariachergui.worldnews.fragmentsNews.HomeViewModel

class HomeAdapter(val weBsite: Lastestnews):RecyclerView.Adapter<HomeViewModel>(){
       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewModel {
        var v=LayoutInflater.from(parent.context).inflate(R.layout.source_cell,parent,false)
           return HomeViewModel(v)
       }

       override fun getItemCount(): Int {
          return weBsite.sources!!.size
       }

       override fun onBindViewHolder(holder: HomeViewModel, position: Int) {

            try {
                var news=weBsite.sources!!.get(position)
                holder?.news=news
                holder?.sourcenewsname?.text= Html.fromHtml(news.name)


            }catch (e:Exception){

            } finally {

           }

       }


   }