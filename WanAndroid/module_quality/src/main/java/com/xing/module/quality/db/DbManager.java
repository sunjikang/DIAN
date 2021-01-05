package com.xing.module.quality.db;

import android.database.sqlite.SQLiteDatabase;

import com.xing.commonbase.base.BaseApplication;

import org.greenrobot.greendao.database.Database;

public class DbManager {

    private static DbManager instance;
    private final QCCodeDao qcCodeDao;
    private final QCRecordCodeDao qcRecordCodeDao;
    private final QCRecordDao qcRecordDao;
    private final QCRImageDao qcrImageDao;
    private final PlanDao planDao;
    private final PlanMonthDao planMonthDao;


    private DbManager() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(BaseApplication.getApplication().getApplicationContext(), "quality");
//        SQLiteDatabase database = helper.getWritableDatabase();
        Database database = helper.getEncryptedWritableDb("hzcs");
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        qcCodeDao = daoSession.getQCCodeDao();
        qcRecordCodeDao = daoSession.getQCRecordCodeDao();
        qcRecordDao = daoSession.getQCRecordDao();
        qcrImageDao = daoSession.getQCRImageDao();
        planDao = daoSession.getPlanDao();
        planMonthDao = daoSession.getPlanMonthDao();
    }

    public static DbManager getInstance() {
        if (instance == null) {
            synchronized (DbManager.class) {
                if (instance == null) {
                    instance = new DbManager();
                }
            }
        }
        return instance;
    }

    public QCCodeDao getQCCodeDao() {
        return qcCodeDao;
    }

    public QCRecordCodeDao getQCRecordCodeDao() {
        return qcRecordCodeDao;
    }

    public QCRecordDao getQCRecordDao() {
        return qcRecordDao;
    }

    public QCRImageDao getQCRImageDao() {
        return qcrImageDao;
    }

    public PlanDao getPlanDao() {
        return planDao;
    }

    public PlanMonthDao getPlanMonthDao() {
        return planMonthDao;
    }
}
