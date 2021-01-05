package com.xing.module.quality.presenter;

import com.xing.commonbase.base.BaseObserver;
import com.xing.commonbase.mvp.BasePresenter;
import com.xing.module.quality.apiservice.ApiService;
import com.xing.module.quality.bean.Plan;
import com.xing.module.quality.contract.PlanContract;

import java.util.List;

import retrofit2.http.Url;

public class PlanPresenter extends BasePresenter<PlanContract.View> implements PlanContract.Presenter {

    @Override
    public void getPlanByMonth(@Url String url, final String month) {
        addSubscribe(create(ApiService.class).getPlanByMonth(url + "/quality/tblschedulemain/getPlanByMonth", month),
                new BaseObserver<List<Plan>>(getView()) {
                    @Override
                    protected void onSuccess(List<Plan> data) {
                        if (isViewAttached()) {
                            getView().getPlanByMonth(data, month);
                        }
                    }
                });
    }
}
