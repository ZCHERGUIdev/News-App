package com.zakariachergui.worldnews.MdaelBlogNEws

import com.google.gson.annotations.SerializedName

data class ArticlesItemBlog(@SerializedName("publishedAt")
                            val publishedAt: String = "",
                            @SerializedName("author")
                            val author: String = "",
                            @SerializedName("urlToImage")
                            val urlToImage: String = "",
                            @SerializedName("description")
                            val description: String = "",
                            @SerializedName("source")
                            val source: SourceBlog,
                            @SerializedName("title")
                            val title: String = "",
                            @SerializedName("url")
                            val url: String = "",
                            @SerializedName("content")
                            val content: String = "")