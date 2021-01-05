package com.xing.usercenter.activity;

import android.text.TextUtils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.xing.commonbase.base.BaseActivity;
import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.util.SharedPreferenceUtil;
import com.xing.usercenter.R;


public class SplashActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        String token = SharedPreferenceUtil.read(Constants.FILE_TOKEN, Constants.ACCESS_TOKEN, "");
        if (!TextUtils.isEmpty(token)) {
             gotoMainActivity();

        } else {
           //gotoMainActivity();

          gotoLoginActivity();
        }
    }

    /**
     * 跳转主界面
     */
    private void gotoMainActivity() {
        ARouter.getInstance().build("/main/MainActivity").navigation();
        finish();
    }

    /**
     * 跳转登录界面
     */
    private void gotoLoginActivity() {
        ARouter.getInstance().build("/user/LoginActivity").navigation();
        finish();
    }
}
