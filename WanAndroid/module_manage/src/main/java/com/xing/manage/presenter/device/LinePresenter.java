package com.xing.manage.presenter.device;

import android.util.Log;

import com.xing.commonbase.base.BaseObserver;
import com.xing.commonbase.mvp.BasePresenter;
import com.xing.manage.apiservice.ManageApiService;
import com.xing.manage.bean.ActPage;
import com.xing.manage.bean.ProcessNodeVo;
import com.xing.manage.bean.device.Line;
import com.xing.manage.bean.manage.DoneBean;
import com.xing.manage.bean.manage.ProgressManageBean;
import com.xing.manage.contract.ProgressManageContract;
import com.xing.manage.contract.device.LineContract;

import java.util.List;

import io.reactivex.annotations.NonNull;


public class LinePresenter extends BasePresenter<LineContract.View> implements LineContract.Presenter {


    @Override
    public void getAllLine() {
        addSubscribe(create(ManageApiService.class).getAllLine(), new BaseObserver<List<Line>>() {
            @Override
            protected void onSuccess(List<Line> data) {
                Log.e("sjk","========="+data.toString());
                if (isViewAttached()) {
                    getView().getAllLine(data);
                 }
            }
        });


    }
}
