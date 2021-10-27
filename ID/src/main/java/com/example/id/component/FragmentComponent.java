package com.example.id.component;

import android.content.Context;


import com.example.id.module.FragmentModule;
import com.example.id.scope.ActivityScope;

import dagger.Component;

/**
 * @Name:yao
 * @CreateDate: 2021/10/21 19:28
 * @ProjectName: SmallVideo
 * @Package: com.example.id.component
 * @ClassName: aa
 */
@ActivityScope
@Component(dependencies = {AppComponent.class},modules = {FragmentModule.class})
public interface FragmentComponent {
    Context context();
}

