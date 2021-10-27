package com.example.mvvmcore.module;



import com.example.mvvmcore.model.IModel;

import dagger.Module;
import dagger.Provides;
/**
 * @Name:yao
 * @CreateDate: 2021/10/21 19:32
 * @ProjectName: SmallVideo
 * @Package: com.example.mvvmcore.view
 * @ClassName: aaa
 */
@Module
public class ModelModule {
    private IModel model;

    public ModelModule(IModel _model) {
        this.model = _model;
    }

    @Provides
    public IModel provideModel(){
        return this.model;
    }
}
