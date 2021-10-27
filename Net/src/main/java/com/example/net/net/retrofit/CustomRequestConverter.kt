package com.example.net.net.retrofit

import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Converter

class CustomRequestConverter<T> : Converter<T,RequestBody>  {

    override fun convert(value: T): RequestBody {
        val toJson = Gson().toJson(value)
        return RequestBody.create(MediaType.parse("application/json; charset=UTF-8"),toJson)
    }
}