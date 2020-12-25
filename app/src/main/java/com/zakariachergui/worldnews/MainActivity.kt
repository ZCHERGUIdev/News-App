package com.zakariachergui.worldnews

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.zakariachergui.worldnews.fragmentsNews.BlogFragment
import com.zakariachergui.worldnews.fragmentsNews.CategorisFragment
import com.zakariachergui.worldnews.fragmentsNews.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), AHBottomNavigation.OnTabSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.nav.setOnTabSelectedListener(this)
        this.creattabs()

    }
    fun creattabs() {
        var home = AHBottomNavigationItem("News",
            R.drawable.news
        )
        var category = AHBottomNavigationItem("Usa News",
            R.drawable.american
        )
        var about = AHBottomNavigationItem("Blog",
            R.drawable.blogger
        )


        //nav.isBehaviorTranslationEnabled=false
        nav.addItem(category)
        nav.addItem(home)
        nav.addItem(about)

        nav.defaultBackgroundColor = Color.parseColor("#ffffff")
        nav.accentColor = Color.parseColor("#09091a")
        nav.inactiveColor = Color.parseColor("#c0c0c8")
        nav.currentItem = 1


    }
    override fun onTabSelected(position: Int, wasSelected: Boolean): Boolean {

        when (position) {
            0 -> {
                val frg1 = CategorisFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, frg1).commit()
            }
            1 -> {
                val frg1 = HomeFragment()

                supportFragmentManager.beginTransaction().replace(R.id.container, frg1).commit()
            }
            2 -> {
                val frg1 = BlogFragment()

                supportFragmentManager.beginTransaction().replace(R.id.container, frg1).commit()
            }
        }

        return true
    }
}
