package com.xing.manage.contract.device;

import com.xing.commonbase.mvp.IView;
import com.xing.manage.bean.ProcessNodeVo;
import com.xing.manage.bean.device.Line;
import com.xing.manage.bean.manage.DoneBean;

import java.util.List;

public interface LineContract {

    interface View extends IView {
        void getAllLine(List<Line> list);

    }

    interface Presenter {
        void getAllLine();

     }
}
