package com.example.mvvmcore.view;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.id.BaseApplication;
import com.example.id.component.ActivityComponent;
import com.example.id.component.DaggerActivityComponent;
import com.example.id.module.ActivityModule;

/**
 * @Name:yao
 * @CreateDate: 2021/10/21 19:28
 * @ProjectName: SmallVideo
 * @Package: com.example.id.component
 * @ClassName: aa
 */
public abstract class BaseActivity extends BaseMVVMActivity{

    protected ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        activityComponent = DaggerActivityComponent.builder().appComponent(((BaseApplication) getApplication()).appComponent)
                .activityModule(new ActivityModule(this))
                .build();
        injectCompoent();
        super.onCreate(savedInstanceState);
    }
    protected abstract void injectCompoent();
}
