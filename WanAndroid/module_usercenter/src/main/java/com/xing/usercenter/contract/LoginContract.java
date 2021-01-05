package com.xing.usercenter.contract;

import com.xing.commonbase.mvp.IView;
import com.xing.usercenter.bean.LoginResult;

public interface LoginContract {

    interface View extends IView {
        void loginSuccess(String token);

        void loginError();
    }

    interface Presenter {
        void login(String phone, String password, String deviceUniqueCode);
    }
}