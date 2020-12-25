package com.zakariachergui.worldnews.NewsModels

import com.google.gson.annotations.SerializedName

data class ListeofNEws(@SerializedName("totalResults")
                       val totalResults: Int = 0,
                       @SerializedName("articles")
                       val articles: List<ArticlesItem>?,
                       @SerializedName("status")
                       val status: String = "")