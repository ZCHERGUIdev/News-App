package com.zakariachergui.worldnews.NewsModels

import com.google.gson.annotations.SerializedName

data class Source(@SerializedName("name")
                  val name: String = "",
                  @SerializedName("id")
                  val id: String = "")