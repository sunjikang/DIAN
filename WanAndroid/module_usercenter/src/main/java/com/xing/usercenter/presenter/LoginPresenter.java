package com.xing.usercenter.presenter;

import android.text.TextUtils;

import com.xing.commonbase.base.BaseObserver;
import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.mvp.BasePresenter;
import com.xing.commonbase.util.SharedPreferenceUtil;
import com.xing.usercenter.apiservice.UserCenterApiService;
import com.xing.usercenter.bean.LoginResult;
import com.xing.usercenter.contract.LoginContract;

public class LoginPresenter extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter {

    @Override
    public void login(String username, String password, String deviceUniqueCode) {
        addSubscribe(create(UserCenterApiService.class).login(username, password, deviceUniqueCode, 1), new BaseObserver<String>(getView()) {

            @Override
            protected void onSuccess(String token) {
                if (isViewAttached()) {
                    getView().loginSuccess(token);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                getView().loginError();
            }
        });
    }
}
