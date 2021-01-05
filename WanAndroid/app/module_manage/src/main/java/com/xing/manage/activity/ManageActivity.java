package com.xing.manage.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xing.commonbase.base.BaseActivity;
import com.xing.manage.R;

@Route(path = "/manage/ManageActivity")
public class ManageActivity extends BaseActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_manage;
    }

    @Override
    protected void initView() {

    }
}
