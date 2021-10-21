package com.example.mvvmcore.view;

import android.os.Bundle;

import androidx.annotation.Nullable;


import com.example.id.BaseApplication;
import com.example.id.component.DaggerFragmentComponent;
import com.example.id.component.FragmentComponent;
import com.example.id.module.FragmentModule;

/**
 * @Name:yao
 * @CreateDate: 2021/10/21 19:28
 * @ProjectName: SmallVideo
 * @Package: com.example.id.component
 * @ClassName: aa
 */
public abstract class BaseFragment extends BaseMVVMFragment{

    protected FragmentComponent fragmentComponent;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        fragmentComponent = DaggerFragmentComponent.builder().appComponent(((BaseApplication) getContext().getApplicationContext()).appComponent)
                .fragmentModule(new FragmentModule(this))
                .build();
        injectComponent();
        super.onActivityCreated(savedInstanceState);

    }

    protected abstract void injectComponent();

}
