package com.example.net.net.retrofit

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class DefaultCallAdapter<R>(var mType:Type) : CallAdapter<R,Any>{

    override fun responseType(): Type {
        return mType
    }

    override fun adapt(call: Call<R>): Any {
        return call
    }
}