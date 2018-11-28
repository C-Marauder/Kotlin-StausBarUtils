package com.xqy.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.core.statusbarhelper.StatusBarHelper

class MainActivity : AppCompatActivity() {
    private var isFirst:Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloView.setOnClickListener {
            isFirst = !isFirst
            StatusBarHelper.setStatusBarMode(this,isFirst)
        }

    }
}
