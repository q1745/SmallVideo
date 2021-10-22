package com.example.zz

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bytedance.sdk.openadsdk.AdSlot
import com.bytedance.sdk.openadsdk.TTAdSdk

import com.bytedance.sdk.openadsdk.TTAdNative
import com.bytedance.sdk.openadsdk.TTSplashAd


class AdSlotActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adslot_activity)
        //创建TTAdNative对象，createAdNative(Context context) context需要传入Activity对象
        val mTTAdNative = TTAdSdk.getAdManager().createAdNative(this)
        var adSlot : AdSlot = AdSlot.Builder()
            .setCodeId("5224504")
            .setImageAcceptedSize(960, 1600)
            .build()

        mTTAdNative.loadSplashAd(adSlot,object : TTAdNative.SplashAdListener{
            override fun onError(p0: Int, p1: String?) {

            }

            override fun onTimeout() {

            }

            override fun onSplashAdLoad(p0: TTSplashAd?) {
                if(p0 == null){
                    return
                }
                var view:View = p0.splashView
//                if (view != null && mSplashContainer != null && !this.isFinishing()) {
//                    mSplashContainer.removeAllViews();
//                    //把SplashView 添加到ViewGroup中,注意开屏广告view：width =屏幕宽；height >=75%屏幕高
//                    mSplashContainer.addView(view);
//                    //设置不开启开屏广告倒计时功能以及不显示跳过按钮,如果这么设置，您需要自定义倒计时逻辑
//                    //ad.setNotAllowSdkCountdown();
//                }else {
//                    //开发者处理跳转到APP主页面逻辑
//                }
            }

        })
    }
}