package com.xing.module.quality.contract;

import com.xing.commonbase.mvp.IView;
import com.xing.module.quality.bean.Plan;

import java.util.List;

public interface PlanContract {
    interface View extends IView {
        void getPlanByMonth(List<Plan> data, String month);
    }

    interface Presenter {
        void getPlanByMonth(String url,String month);
    }
}
