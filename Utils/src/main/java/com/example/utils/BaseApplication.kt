package com.example.common

import android.app.Application
import android.content.Context

/**
 * Application基类
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
//        ARouter.openLog()
//        ARouter.openDebug()
//        ARouter.init(this)
    }

    /**
     * 获取Application的上下文
     */
    companion object{
        lateinit var context: Context
    }



}