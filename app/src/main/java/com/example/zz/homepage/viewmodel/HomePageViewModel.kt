package com.example.zz.homepage.viewmodel

import androidx.lifecycle.LifecycleOwner
import com.example.mvvmcore.viewmodel.BaseViewModel
import com.example.zz.homepage.repository.HomePageRepository

class HomePageViewModel(owner : LifecycleOwner) : BaseViewModel<HomePageRepository>(owner){


    override fun createRepository() : HomePageRepository {
        return HomePageRepository()
    }
}