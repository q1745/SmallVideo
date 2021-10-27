package com.example.net.net.retrofit

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.IllegalArgumentException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class LiveDataCallAdapterFactory : CallAdapter.Factory() {

    companion object{
        fun create() : LiveDataCallAdapterFactory{
            return LiveDataCallAdapterFactory()
        }
    }

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if(!(returnType is ParameterizedType)){
            throw IllegalArgumentException("必须支持泛型")
        }
        var returnTypeClazz : Class<*> = CallAdapter.Factory.getRawType(returnType)
        if (returnTypeClazz != LiveData::class.java && returnTypeClazz != Call::class.java){
            throw IllegalArgumentException("返回值必须是LiveData  or  Call")
        }
        val t : Type=
            CallAdapter.Factory.getParameterUpperBound(0, returnType as ParameterizedType)
        if (returnTypeClazz == Call::class.java) {
            return DefaultCallAdapter<Any>(t)
        } else if (returnTypeClazz == LiveData::class.java){
            return LiveDataCallAdapter<Any>(t)
        }
        return DefaultCallAdapter<Any>(t)
    }
}