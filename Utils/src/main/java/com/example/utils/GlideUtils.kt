package com.example.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object GlideUtils {

    /**
     * 加载图片
     */
    fun loadImage(context:Context,url:String,view:ImageView){
        Glide.with(context).load(url).into(view)
    }

    /**
     * 加载圆形图片
     */
    fun loadCircleImage(context: Context,url: String,view: ImageView){
        Glide.with(context).load(url).circleCrop().into(view)
    }

}