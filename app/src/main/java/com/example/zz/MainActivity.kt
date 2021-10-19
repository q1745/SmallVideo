package com.example.zz

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.shuke.logger.Logger

class MainActivity : AppCompatActivity() {

    lateinit var vp: ViewPager
    lateinit var bottomBar: BottomNavigationBar

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        //绘制布局前切换布局样式
        setTheme(R.style.Theme_SmallVideo)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView();


        //Log工具
        Logger.Build().setLog("志强是沙雕").setTag("志强沙雕").build().d()

    }

    private fun initView() {
        vp = findViewById(R.id.main_vp)
    }
}