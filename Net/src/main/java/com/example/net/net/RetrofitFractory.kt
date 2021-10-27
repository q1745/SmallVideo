package com.example.net.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KProperty

class RetrofitFractory {
    companion object{
        val retrofitFactory:RetrofitFractory by lazy(LazyThreadSafetyMode.SYNCHRONIZED){
            RetrofitFractory()
        }
    }
    val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("http://123.56.232.18:8080/serverdemo")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkHttpClient())
            .build()
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(createLogInterce())
            .addInterceptor(createTokenInterceptor())
            .build()
    }

    private fun createLogInterce(): Interceptor {
        val logInterceptor=HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return logInterceptor
    }

    private fun createTokenInterceptor(): Interceptor {
        val initerceptor = Interceptor {
            val request = it.request()
            it.proceed(request.newBuilder().addHeader("token","").build())
        }
        return initerceptor
    }
}
