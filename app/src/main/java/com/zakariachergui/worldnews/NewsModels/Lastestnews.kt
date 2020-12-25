package com.zakariachergui.worldnews.NewsModels

import com.google.gson.annotations.SerializedName

data class Lastestnews(@SerializedName("sources")
                       val sources: List<SourcesItem>?,
                       @SerializedName("status")
                       val status: String = "")