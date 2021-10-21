package com.example.zz

import android.content.Context
import android.content.SharedPreferences

/**
 * SP工具类
 * 提供存取功能
 */
object SPUtils {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var edit: SharedPreferences.Editor
    fun getIntence(context: Context) : SPUtils{
        sharedPreferences = context.getSharedPreferences("PPJoke", Context.MODE_PRIVATE)
        edit = sharedPreferences.edit()
        return SPUtils
    }

    /**
     * 存入数据，根据类型判断
     */
    fun put(key:String,value:Any){
        when(value){
            is String -> edit.putString(key,value)
            is Int -> edit.putInt(key,value)
            is Float -> edit.putFloat(key,value)
            is Boolean -> edit.putBoolean(key,value)
            is Long -> edit.putLong(key,value)
        }
        edit.commit()
    }

    /**
     * 获取字符串数据
     */
    fun getString(key: String,default:String) : String? {
        return sharedPreferences.getString(key,default)
    }

    /**
     * 获取整形数据
     */
    fun getInt(key: String,default:Int):Int{
        return sharedPreferences.getInt(key,default)
    }

    /**
     * 获取浮点型数据
     */
    fun getFloat(key: String,default:Float) : Float{
        return sharedPreferences.getFloat(key,default)
    }

    /**
     * 获取布尔型
     */
    fun getBoolean(key: String,default:Boolean):Boolean{
        return sharedPreferences.getBoolean(key,default)
    }

    /**
     * 获取长整形数据
     */
    fun getLong(key: String,default:Long):Long{
        return sharedPreferences.getLong(key,default)
    }
}