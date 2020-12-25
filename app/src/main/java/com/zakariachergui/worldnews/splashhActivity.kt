package com.zakariachergui.worldnews

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast

class splashhActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashh)
        if(NetworkisConnected())
        {
            Handler().postDelayed({
                startActivity(
                    Intent(this@splashhActivity,
                        MainActivity::class.java)
                )
            },3000)}else
        {//else exit the app
            Toast.makeText(this,"Please Check Your Network Connection",Toast.LENGTH_SHORT).show()
            exitApp()
        }
    }


    private fun NetworkisConnected():Boolean{
        var connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var networkinfo=connectivityManager.activeNetworkInfo
        return  networkinfo!=null&&networkinfo.isConnected
    }
    private fun exitApp()
    {
           finish()
           System.exit(0)
    }

}

