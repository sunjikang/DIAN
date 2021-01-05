package com.xing.main.fragment;

import android.graphics.Color;
import android.view.View;

import com.xing.commonbase.base.BaseMVPFragment;
import com.xing.commonbase.mvp.IPresenter;
import com.xing.commonbase.util.StatusBarUtil;
import com.xing.main.R;

/**
 * 体系
 */
public class SystemFragment extends BaseMVPFragment   {


    @Override
    protected IPresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_system;
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void initData() {

    }




    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
