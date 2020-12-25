package com.zakariachergui.worldnews.MdaelBlogNEws

import com.google.gson.annotations.SerializedName

data class SourceBlog(@SerializedName("name")
                      val name: String = "",
                      @SerializedName("id")
                      val id: String = "")