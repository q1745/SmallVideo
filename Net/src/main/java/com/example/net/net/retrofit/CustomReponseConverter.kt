package com.example.net.net.retrofit

import com.example.net.net.protocol.BaseRepoEntity
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import java.lang.reflect.Type

class CustomReponseConverter<T>(var mType:Type) : Converter<ResponseBody,T>{


    override fun convert(value: ResponseBody): T {
        val jsonContent = value.string()
        val gson = Gson()
        val temp_result = gson.fromJson(jsonContent, BaseRepoEntity::class.java)
        return if ((temp_result as BaseRepoEntity).code <= 0) {
            temp_result as T
        } else {
            gson.fromJson(jsonContent, mType)
        }
    }
}