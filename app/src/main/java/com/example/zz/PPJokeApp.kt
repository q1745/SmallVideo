package com.example.zz

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter

class PPJokeApp : Application() {

    companion object{
        lateinit var context:Context
    }

    override fun onCreate() {
        super.onCreate()

        context = this

        ARouter.init(this)
        ARouter.openDebug()
        ARouter.openLog()
    }
}