package com.xing.main.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.xing.commonbase.base.BaseObserver;
import com.xing.commonbase.mvp.BasePresenter;
import com.xing.commonbase.util.ToastUtil;
import com.xing.main.apiservice.MainApiService;
import com.xing.main.bean.CheckVersion;
import com.xing.main.bean.xboot.User;
import com.xing.main.contract.MineContract;

public class MinePresenter extends BasePresenter<MineContract.View> implements MineContract.Presenter {


    /**
     * 获取 userInfo 数据
     */
    @Override
    public void getUserInfo() {
        addSubscribe(create(MainApiService.class).getUserInfo(), new BaseObserver<User>(getView()) {
            @Override
            protected void onSuccess(User user) {
                if (isViewAttached()) {
                    getView().onUserInfo(user);
                }
            }
        });


    }

    /**
     * 检查版本接口
     */
    @Override
    public void checkVersion() {
        addSubscribe(create(MainApiService.class).checkVersion(), new BaseObserver<CheckVersion>(getView()) {

            @Override
            protected void onSuccess(CheckVersion data) {
                if (isViewAttached()) {
                    getView().onCheckSuccess(data);
                    Log.e("sjk","data.getResult()=="+data.toString());

                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Log.e("sjk","checkVersion出现错误");
            }
        });
    }


}
