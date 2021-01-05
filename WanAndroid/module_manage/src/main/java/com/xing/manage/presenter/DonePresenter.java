package com.xing.manage.presenter;

import android.util.Log;

import com.xing.commonbase.base.BaseObserver;
import com.xing.commonbase.mvp.BasePresenter;
import com.xing.manage.apiservice.ManageApiService;
import com.xing.manage.bean.ActPage;
import com.xing.manage.bean.manage.DoneBean;
import com.xing.manage.bean.ProcessNodeVo;
import com.xing.manage.contract.DoneContract;


public class DonePresenter extends BasePresenter<DoneContract.View> implements DoneContract.Presenter {
    /**
     * 获取 已办列表 数据
     */
    @Override
    public void getDoneList(int pageNumber, int pageSize) {
        addSubscribe(create(ManageApiService.class).getDoneList(pageNumber, pageSize), new BaseObserver<ActPage<DoneBean>>(getView()) {
            @Override
            protected void onSuccess(ActPage<DoneBean> page) {
                Log.e("sjk","========="+page.getContent().toString());
                if (isViewAttached()) {
                    getView().onDoneList(page.getContent());
                }
            }
        });
    }

    @Override
    public void pass(String id, String procInstId, String[] assignees, Integer priority, String comment, Boolean sendMessage, Boolean sendSms, Boolean sendEmail) {
        addSubscribe(create(ManageApiService.class).pass(id, procInstId,assignees,priority,comment,sendMessage,sendSms,sendEmail), new BaseObserver<Object>(getView()) {
            @Override
            protected void onSuccess(Object result) {
                if (isViewAttached()) {
                    getView().onPass();
                }
            }
        });
    }

    @Override
    public void back(String id, String procInstId, String comment, Boolean sendMessage, Boolean sendSms, Boolean sendEmail) {
        addSubscribe(create(ManageApiService.class).back(id, procInstId,comment,sendMessage,sendSms,sendEmail), new BaseObserver<Object>(getView()) {
            @Override
            protected void onSuccess(Object result) {
                if (isViewAttached()) {
                    getView().onBack();
                }
            }
        });
    }

    @Override
    public void delegate(String id, String userId, String procInstId, String comment, Boolean sendMessage, Boolean sendSms, Boolean sendEmail) {
        addSubscribe(create(ManageApiService.class).delegate(id,userId, procInstId,comment,sendMessage,sendSms,sendEmail), new BaseObserver<Object>(getView()) {
            @Override
            protected void onSuccess(Object result) {
                if (isViewAttached()) {
                    getView().onDelegate();
                }
            }
        });
    }

    @Override
    public void getNextNode(String procDefId, String currActId) {
        addSubscribe(create(ManageApiService.class).getNextNode(procDefId, currActId), new BaseObserver<ProcessNodeVo>(getView()) {
            @Override
            protected void onSuccess(ProcessNodeVo data) {
                if (isViewAttached()) {
                    getView().onNextNode(data);
                }
            }
        });
    }
}
