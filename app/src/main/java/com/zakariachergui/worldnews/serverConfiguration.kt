package com.zakariachergui.worldnews

import android.app.Application
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

public class serverConfiguration : Application() {

    companion object {
        private var Tag = serverConfiguration::class.java.simpleName
        //senglton app
        @get:Synchronized
        var instence: serverConfiguration? = null
    }

    var requestQueue: RequestQueue? = null
        get() {
            if (field != null) {
                return Volley.newRequestQueue(applicationContext)
            } else {
                return field
            }
        }

    override fun onCreate() {
        super.onCreate()
        instence = this
    }

    fun <T> addRequestQueue(request: Request<T>) {
        request.tag = Tag
        requestQueue?.add(request)
    }

}