package com.xing.manage.contract;

import com.xing.commonbase.mvp.IView;
import com.xing.manage.bean.manage.DoneBean;
import com.xing.manage.bean.ProcessNodeVo;

import java.util.List;

public interface DoneContract {

    interface View extends IView {
        void onDoneList(List<DoneBean> list);

        void onPass();

        void onBack();

        void onDelegate();

        void onNextNode(ProcessNodeVo processNodeVo);
    }

    interface Presenter {
        void getDoneList(int pageNumber, int pageSize);

        void pass(String id,
                  String procInstId,
                  String[] assignees,
                  Integer priority,
                  String comment,
                  Boolean sendMessage,
                  Boolean sendSms,
                  Boolean sendEmail);

        void back(String id,
                  String procInstId,
                  String comment,
                  Boolean sendMessage,
                  Boolean sendSms,
                  Boolean sendEmail);

        void delegate(String id,
                      String userId,
                      String procInstId,
                      String comment,
                      Boolean sendMessage,
                      Boolean sendSms,
                      Boolean sendEmail);

        void getNextNode(String procDefId, String currActId);
    }
}
