package com.example.mvvmcore.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;


import com.example.mvvmcore.viewmodel.BaseViewModel;

import java.util.HashMap;
import java.util.Map;
/**
 * @Name:yao
 * @CreateDate: 2021/10/21 19:30
 * @ProjectName: SmallVideo
 * @Package: com.example.mvvmcore.view
 * @ClassName: aaa
 */
public abstract class BaseMVVMFragment <VM extends BaseViewModel,Binding extends ViewDataBinding> extends Fragment {
    protected Binding mBinding;
    protected VM mViewModel;
    private HashMap<Integer,Object> mMap=new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        mBinding.setLifecycleOwner(this);
        mViewModel=createViewModel();
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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