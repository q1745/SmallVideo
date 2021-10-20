package com.example.zz

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

/**
 * Arouter路由的登录拦截器
 * 跳转到需要登录的页面进行判断
 * 登录状态->放行
 * 未登录状态->拦截并跳转登录界面
 */
@Interceptor(priority = 6)
class LoginInterceptor : IInterceptor{
    override fun init(context: Context?) {

    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        if (postcard != null) {
//            callback!!.onContinue(postcard)
            checkIsLogin(postcard,callback)
//            when(postcard.path){
//                "/a/a" -> checkIsLogin(postcard,callback)
//            }
        }
    }

    fun checkIsLogin(postcard: Postcard, callback: InterceptorCallback?) {
        if (SPUtils.getIntence(PPJokeApp.context).getBoolean("login",false)){
            callback!!.onContinue(postcard)
        }else{
            callback!!.onInterrupt(null)
        }
    }
}