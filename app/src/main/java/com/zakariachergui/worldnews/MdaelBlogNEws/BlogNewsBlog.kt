package com.zakariachergui.worldnews.MdaelBlogNEws

import com.google.gson.annotations.SerializedName

data class BlogNewsBlog(@SerializedName("totalResults")
                        val totalResults: Int = 0,
                        @SerializedName("articles")
                        val articles: List<ArticlesItemBlog>?,
                        @SerializedName("status")
                        val status: String = "")