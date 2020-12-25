package com.zakariachergui.worldnews.modalusanews

import com.google.gson.annotations.SerializedName

data class ArticlesItemUsa(@SerializedName("publishedAt")
                           val publishedAt: String = "",
                           @SerializedName("author")
                           val author: String = "",
                           @SerializedName("urlToImage")
                           val urlToImage: String = "",
                           @SerializedName("description")
                           val description: String = "",
                           @SerializedName("source")
                           val source: SourceUsa,
                           @SerializedName("title")
                           val title: String = "",
                           @SerializedName("url")
                           val url: String = ""

                            )