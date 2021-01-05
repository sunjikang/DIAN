package com.xing.main.fragment;

import android.content.Context;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;


import com.alibaba.android.arouter.launcher.ARouter;

import com.xing.commonbase.base.BaseMVPFragment;

import com.xing.commonbase.util.StatusBarUtil;
import com.xing.main.R;
import com.xing.main.contract.HomeContract;
 import com.xing.main.presenter.HomePresenter;

public class HomeFragment extends BaseMVPFragment<HomePresenter> implements HomeContract.View, View.OnClickListener {

    private static final String TAG = "HomeFragment";

       private ImageView iv_manage;
     private ImageView iv_device;
     public HomeFragment() {
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView(View rootView) {
        iv_manage = rootView.findViewById(R.id.imageView2);
        iv_device = rootView.findViewById(R.id.imageView3);
    }

    @Override
    protected void initData() {
        setListener();
      }

    private void setListener() {
        iv_manage.setOnClickListener(this);
        iv_device.setOnClickListener(this);

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.imageView2) {
            gotoManageActivity();
        } else if (id == R.id.imageView3) {
            gotoDeviceActivity();
        }

    }
    private void gotoDeviceActivity() {
        ARouter.getInstance()
                .build("/manage/device/DeviceActivity")
                .navigation();

    }
    private void gotoManageActivity() {
        ARouter.getInstance()
                .build("/manage/ManageActivity")
                .navigation();

    }

}
