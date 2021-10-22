package com.example.zz

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.bytedance.sdk.openadsdk.TTAdConfig
import com.bytedance.sdk.openadsdk.TTAdConstant
import com.bytedance.sdk.openadsdk.TTAdSdk

class PPJokeApp : Application() {

    companion object{
        lateinit var context:Context
    }

    override fun onCreate() {
        super.onCreate()

        context = this

        //ARouter初始化
        ARouter.init(this)
        ARouter.openDebug()
        ARouter.openLog()


    }
}