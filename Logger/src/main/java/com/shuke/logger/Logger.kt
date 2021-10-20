package com.shuke.logger

import android.util.Log
import java.util.logging.Logger

/**
 * 可开启关闭的简易版LogUtils
 */
class Logger(var IsDeBug : Boolean,var Tag : String,var log: String) {

    class Build(){
        var IsDeBug : Boolean = true
        var TAG:String = "PPJoke"
        var log : String = ""

        fun setDeBug(DeBug:Boolean) : Build{
            IsDeBug = DeBug
            return this
        }

        fun setTag(tag : String) : Build{
            TAG = tag
            return this
        }

        fun setLog(log: String) : Build{
            this.log = log
            return this
        }

        fun build() : com.shuke.logger.Logger {
            return Logger(this.IsDeBug,TAG,log)
        }
    }

    fun d(){
        Log.d(Tag, log)
    }
    fun i(){
        Log.i(Tag, log)
    }
    fun e(){
        Log.e(Tag, log)
    }
    fun v(){
        Log.v(Tag, log)
    }
}