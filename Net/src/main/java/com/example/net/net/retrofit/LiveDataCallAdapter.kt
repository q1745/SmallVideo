package com.example.net.net.retrofit

import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.net.net.protocol.BaseRepoEntity
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

class LiveDataCallAdapter<R>(var mType : Type) : CallAdapter<R,LiveData<BaseRepoEntity<R>>> {
    override fun responseType(): Type {
        return mType
    }

    override fun adapt(call: Call<R>): LiveData<BaseRepoEntity<R>> {
        val liveData : MutableLiveData<BaseRepoEntity<R>> = MutableLiveData()
        call.enqueue(object : Callback<R>{
            override fun onResponse(call: Call<R>, response: Response<R>) {
                if (Looper.getMainLooper().thread == Thread.currentThread()){
                    liveData.value = response.body() as BaseRepoEntity<R>
                }else{
                    liveData.postValue(response.body() as BaseRepoEntity<R>)
                }
            }

            override fun onFailure(call: Call<R>, t: Throwable) {
                var entity : BaseRepoEntity<String> = BaseRepoEntity(-11,"",t.message.toString())
                if (Looper.getMainLooper().thread == Thread.currentThread()){
                    liveData.value = entity as BaseRepoEntity<R>
                }else{
                    liveData.postValue(entity as BaseRepoEntity<R>)
                }
            }

        })
        return liveData
    }
}