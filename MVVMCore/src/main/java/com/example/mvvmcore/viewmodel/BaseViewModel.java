package com.example.mvvmcore.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;


import com.example.mvvmcore.repository.BaseRepository;

import javax.inject.Inject;

/**
 * @Name:yao
 * @CreateDate: 2021/10/21 19:29
 * @ProjectName: SmallVideo
 * @Package: com.example.mvvmcore.view
 * @ClassName: aaa
 */
public abstract class   BaseViewModel<Repo extends BaseRepository> extends ViewModel implements LifecycleObserver {

    @Inject
    protected Repo mRepository;
    private LifecycleOwner mOwner;
    public BaseViewModel(LifecycleOwner owner){
        mRepository=createRepository();
        mOwner=owner;
        mOwner.getLifecycle().addObserver(this);
    }
    protected abstract Repo createRepository();
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void uiConnection(){
        initResource();
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disConnection(){
        releaseResource();
        mOwner.getLifecycle().removeObserver(this);
    }


    protected  void releaseResource(){}

    protected void initResource(){}


}
