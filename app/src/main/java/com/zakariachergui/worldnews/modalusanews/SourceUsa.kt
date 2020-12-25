package com.zakariachergui.worldnews.modalusanews

import com.google.gson.annotations.SerializedName

data class SourceUsa(@SerializedName("name")
                     val name: String = "",
                     @SerializedName("id")
                     val id: String = "")