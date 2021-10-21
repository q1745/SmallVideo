package com.example.mvvmcore.repository;




import com.example.mvvmcore.model.IModel;

import java.util.Map;

import javax.inject.Inject;
/**
 * @Name:yao
 * @CreateDate: 2021/10/21 19:36
 * @ProjectName: SmallVideo
 * @Package: com.example.mvvmcore.view
 * @ClassName: aaa
 */
public abstract class BaseRepository {

    @Inject
    protected Map<String, IModel> models;

    protected IModel getModel(String key){
        if (models!=null&&models.containsKey(key)){
            IModel iModel = models.get(key);
            return iModel;
        }
        return null;
    }

}
