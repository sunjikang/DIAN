package com.xing.manage.contract;

import com.xing.commonbase.mvp.IView;
import com.xing.manage.bean.manage.HistoryBean;

import java.util.List;

public interface HistoryContract {

    interface View extends IView {
        void getHistory(List<HistoryBean> bean);
    }

    interface Presenter {
        void getHistory(String proId);
    }
}
