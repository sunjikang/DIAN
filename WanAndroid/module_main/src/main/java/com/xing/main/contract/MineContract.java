package com.xing.main.contract;

import com.xing.commonbase.mvp.IView;
import com.xing.main.bean.CheckVersion;
import com.xing.main.bean.xboot.User;

public interface MineContract {

    interface View extends IView {
        /**
         * 获取用户数据
         * @param user
         */
        void onUserInfo(User user);

        /**
         * 检测版本成功
         * @param data
         */
        void onCheckSuccess(CheckVersion data);

        /**
         * 检测版本失败
         * @param message
         * https://imtt.dd.qq.com/16891/apk/0E2551A47983D789F22A2247C03A1FD1.apk?fsname=com.ibox.calculators_3.2.2_1322.apk&csr=1bbd
         */
        void  onCheckFail(String message);
    }

    interface Presenter {
        /**
         * 获取用户数据
         */
        void getUserInfo();

        /**
         * 检查版本
         */
        void checkVersion();
    }
}
