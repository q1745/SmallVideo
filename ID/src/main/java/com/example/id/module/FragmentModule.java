package com.example.id.module;

import androidx.fragment.app.Fragment;

import dagger.Module;
import dagger.Provides;


@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment _fragment) {
        fragment = _fragment;
    }

    @Provides
    public Fragment provideFragment(){
        return fragment;
    }
}
