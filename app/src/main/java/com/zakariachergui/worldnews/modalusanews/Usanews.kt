package com.zakariachergui.worldnews.modalusanews

import com.google.gson.annotations.SerializedName

data class Usanews(@SerializedName("totalResults")
                   val totalResults: Int = 0,
                   @SerializedName("articles")
                   val articles: List<ArticlesItemUsa>?,
                   @SerializedName("status")
                   val status: String = "")