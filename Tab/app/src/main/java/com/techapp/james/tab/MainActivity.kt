package com.techapp.james.tab

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.techapp.james.tab.pagerTitleStrip.PagerTitleActivity
import com.techapp.james.tab.tabLayout.TabActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pagerTitleBtn.setOnClickListener {
            var i = Intent(this, PagerTitleActivity::class.java)
            startActivity(i)
        }
        tabBtn.setOnClickListener {
            var i = Intent(this, TabActivity::class.java)
            startActivity(i)
        }
    }
}
