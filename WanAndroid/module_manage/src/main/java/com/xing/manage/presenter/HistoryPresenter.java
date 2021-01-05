package com.xing.manage.presenter;


import android.util.Log;

import com.xing.commonbase.base.BaseObserver;
import com.xing.commonbase.mvp.BasePresenter;
import com.xing.manage.apiservice.ManageApiService;
import com.xing.manage.bean.manage.HistoryBean;
import com.xing.manage.contract.HistoryContract;

import java.util.List;


public class HistoryPresenter extends BasePresenter<HistoryContract.View> implements HistoryContract.Presenter {



    @Override
    public void getHistory(String proId) {
        addSubscribe(create(ManageApiService.class)
                .getHistory(proId),
                new BaseObserver<List<HistoryBean>>(getView()) {
            @Override
            protected void onSuccess(List<HistoryBean> bean) {
                Log.e("sjk","getHistory=========");
                if (isViewAttached()) {
                    getView().getHistory(bean);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Log.e("sjk","getHistory====="+e.getMessage().toString());

            }
        });
    }
}
