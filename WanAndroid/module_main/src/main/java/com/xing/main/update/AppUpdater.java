package com.xing.main.update;

import com.xing.main.update.net.INetManager;
import com.xing.main.update.net.OkHttpNetManager;

public class AppUpdater {

    private static AppUpdater appUpdater = null;

    //默认为OkHttpManager
    private static INetManager netManager = new OkHttpNetManager();

    private AppUpdater() {
    }

    public static AppUpdater getInstance() {
        if (appUpdater == null) {
            appUpdater = new AppUpdater();
        }
        return appUpdater;
    }

    public INetManager getNetManager() {
        return netManager;
    }

    public void setNetManager(INetManager netManager) {
        AppUpdater.netManager = netManager;
    }
}
