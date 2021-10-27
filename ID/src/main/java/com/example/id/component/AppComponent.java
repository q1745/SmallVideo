package com.example.id.component;

import android.content.Context;


import com.example.id.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
/**
 * @Name:yao
 * @CreateDate: 2021/10/21 19:28
 * @ProjectName: SmallVideo
 * @Package: com.example.id.component
 * @ClassName: aa
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context context();
}
