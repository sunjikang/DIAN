package com.xing.commonbase.base;


import com.alibaba.android.arouter.launcher.ARouter;
import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.http.ApiException;
import com.xing.commonbase.http.ExceptionHandler;
import com.xing.commonbase.mvp.IView;
import com.xing.commonbase.util.SharedPreferenceUtil;

import io.reactivex.observers.DisposableObserver;

public abstract class BaseObserver<T> extends DisposableObserver<BaseResponse<T>> {
    private IView baseView;

    public BaseObserver() {

    }

    public BaseObserver(IView baseView) {
        this.baseView = baseView;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (baseView != null) {
            baseView.showLoading();
        }
    }

    @Override
    public void onNext(BaseResponse<T> baseResponse) {
        if (baseView != null) {
            baseView.hideLoading();
        }
        Integer code = baseResponse.getCode();
        String message = baseResponse.getMessage();
        boolean success = baseResponse.isSuccess();
        if (success) { // xboot
            T data = baseResponse.getResult();
            onSuccess(data);
        } else {
            onError(new ApiException(code, message));
            //登录失效
            if(code == 401){
                SharedPreferenceUtil.write(Constants.FILE_TOKEN, Constants.ACCESS_TOKEN, "");
                ARouter.getInstance().build("/user/LoginActivity").navigation();
            }
        }
    }

    /**
     * 回调正常数据
     *
     * @param data
     */
    protected abstract void onSuccess(T data);

    /**
     * 异常处理，包括两方面数据：
     * (1) 服务端没有没有返回数据，HttpException，如网络异常，连接超时;
     * (2) 服务端返回了数据，但 errcode!=0,即服务端返回的data为空，如 密码错误,App登陆超时,token失效
     */
    @Override
    public void onError(Throwable e) {
        if (baseView != null) {
            baseView.hideLoading();
        }
        ExceptionHandler.handleException(e);
    }

    @Override
    public void onComplete() {
        if (baseView != null) {
            baseView.hideLoading();
        }
    }
}
