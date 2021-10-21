package com.example.mvvmcore.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.mvvmcore.viewmodel.BaseViewModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @Name:yao
 * @CreateDate: 2021/10/21 19:41
 * @ProjectName: SmallVideo
 * @Package: com.example.id.component
 * @ClassName: aa
 */
public abstract class BaseMVVMActivity<VM extends BaseViewModel,Binding extends ViewDataBinding> extends AppCompatActivity {
    protected Binding mBinding;
    protected VM mViewModel;
    private HashMap<Integer,Object> mMap=new HashMap<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        //设置生命周期的所有者 如果不设置使用LiveData页面将无法获取到数据的更新
        mBinding.setLifecycleOwner(this);
        mViewModel=createViewModel();
        prepareSetVars(mMap);
        setVars(mBinding,mMap);
        loadData();
        initEvent();
    }


    protected abstract VM createViewModel();


    protected abstract void initEvent();

    protected abstract void loadData();


    private void setVars(Binding mBinding, HashMap<Integer, Object> mMap) {
        if (mMap.size()==0){
            throw new RuntimeException("please set variable...");
        }

        for (Map.Entry<Integer,Object> entry:mMap.entrySet()){
            mBinding.setVariable(entry.getKey(),entry.getValue());
        }
    }

    protected abstract void prepareSetVars(HashMap<Integer, Object> mMap);

    protected abstract int getLayoutId();

}
