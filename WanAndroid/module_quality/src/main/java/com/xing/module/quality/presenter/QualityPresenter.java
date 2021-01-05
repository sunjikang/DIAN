package com.xing.module.quality.presenter;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.xing.commonbase.base.BaseObserver;
import com.xing.commonbase.constants.Constants;
import com.xing.commonbase.mvp.BasePresenter;
import com.xing.commonbase.util.SharedPreferenceUtil;
import com.xing.module.quality.apiservice.ApiService;
import com.xing.module.quality.bean.AppInfo;
import com.xing.module.quality.bean.Plan;
import com.xing.module.quality.bean.QCRImage;
import com.xing.module.quality.bean.QCRecord;
import com.xing.module.quality.contract.QualityContract;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class QualityPresenter extends BasePresenter<QualityContract.View> implements QualityContract.Presenter {

    private static String host = SharedPreferenceUtil.read(Constants.USER_LOGIN, Constants.URL, "");

    @Override
    public void doSubmit(final List<QCRecord> list) {
        String data = JSON.toJSONString(list);
        Map<String, RequestBody> fileMap = new HashMap<>();
        for (QCRecord qcRecord : list) {
            List<QCRImage> qcrImageList = qcRecord.getQcrImageList();
            if (qcrImageList != null && qcrImageList.size() > 0) {
                for (int j = 0; j < qcrImageList.size(); j++) {
                    File file = new File(qcrImageList.get(j).getImageLocalUrl());
                    fileMap.put("files" + "\";filename=\"" + qcrImageList.get(j).getImageName(), RequestBody.create(MediaType.parse("image/png"), file));
                }
            }
        }
        addSubscribe(create(ApiService.class).uploadQuality(host + "/quality/qcrecord/uploadqcRecord", data, fileMap),
                new BaseObserver(getView()) {
                    @Override
                    protected void onSuccess(Object data) {
                        getView().onSubmitSuccess(list);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        getView().hideLoading();
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        getView().hideLoading();
                    }
                });
    }

    @Override
    public void doCheckVersion() {
        addSubscribe(create(ApiService.class).getAppInfo(host + "/app/appinfo/getAppInfo"),
                new BaseObserver(getView()) {

                    @Override
                    protected void onSuccess(Object data) {
                        getView().onCheckVersionSuccess((AppInfo) data);
                    }
                });
    }
}
