package com.xing.module.quality.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.xing.module.quality.bean.Plan;
import com.xing.module.quality.bean.PlanMonth;
import com.xing.module.quality.bean.QCCode;
import com.xing.module.quality.bean.QCRecord;
import com.xing.module.quality.bean.QCRecordCode;
import com.xing.module.quality.bean.QCRImage;

import com.xing.module.quality.db.PlanDao;
import com.xing.module.quality.db.PlanMonthDao;
import com.xing.module.quality.db.QCCodeDao;
import com.xing.module.quality.db.QCRecordDao;
import com.xing.module.quality.db.QCRecordCodeDao;
import com.xing.module.quality.db.QCRImageDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig planDaoConfig;
    private final DaoConfig planMonthDaoConfig;
    private final DaoConfig qCCodeDaoConfig;
    private final DaoConfig qCRecordDaoConfig;
    private final DaoConfig qCRecordCodeDaoConfig;
    private final DaoConfig qCRImageDaoConfig;

    private final PlanDao planDao;
    private final PlanMonthDao planMonthDao;
    private final QCCodeDao qCCodeDao;
    private final QCRecordDao qCRecordDao;
    private final QCRecordCodeDao qCRecordCodeDao;
    private final QCRImageDao qCRImageDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        planDaoConfig = daoConfigMap.get(PlanDao.class).clone();
        planDaoConfig.initIdentityScope(type);

        planMonthDaoConfig = daoConfigMap.get(PlanMonthDao.class).clone();
        planMonthDaoConfig.initIdentityScope(type);

        qCCodeDaoConfig = daoConfigMap.get(QCCodeDao.class).clone();
        qCCodeDaoConfig.initIdentityScope(type);

        qCRecordDaoConfig = daoConfigMap.get(QCRecordDao.class).clone();
        qCRecordDaoConfig.initIdentityScope(type);

        qCRecordCodeDaoConfig = daoConfigMap.get(QCRecordCodeDao.class).clone();
        qCRecordCodeDaoConfig.initIdentityScope(type);

        qCRImageDaoConfig = daoConfigMap.get(QCRImageDao.class).clone();
        qCRImageDaoConfig.initIdentityScope(type);

        planDao = new PlanDao(planDaoConfig, this);
        planMonthDao = new PlanMonthDao(planMonthDaoConfig, this);
        qCCodeDao = new QCCodeDao(qCCodeDaoConfig, this);
        qCRecordDao = new QCRecordDao(qCRecordDaoConfig, this);
        qCRecordCodeDao = new QCRecordCodeDao(qCRecordCodeDaoConfig, this);
        qCRImageDao = new QCRImageDao(qCRImageDaoConfig, this);

        registerDao(Plan.class, planDao);
        registerDao(PlanMonth.class, planMonthDao);
        registerDao(QCCode.class, qCCodeDao);
        registerDao(QCRecord.class, qCRecordDao);
        registerDao(QCRecordCode.class, qCRecordCodeDao);
        registerDao(QCRImage.class, qCRImageDao);
    }
    
    public void clear() {
        planDaoConfig.clearIdentityScope();
        planMonthDaoConfig.clearIdentityScope();
        qCCodeDaoConfig.clearIdentityScope();
        qCRecordDaoConfig.clearIdentityScope();
        qCRecordCodeDaoConfig.clearIdentityScope();
        qCRImageDaoConfig.clearIdentityScope();
    }

    public PlanDao getPlanDao() {
        return planDao;
    }

    public PlanMonthDao getPlanMonthDao() {
        return planMonthDao;
    }

    public QCCodeDao getQCCodeDao() {
        return qCCodeDao;
    }

    public QCRecordDao getQCRecordDao() {
        return qCRecordDao;
    }

    public QCRecordCodeDao getQCRecordCodeDao() {
        return qCRecordCodeDao;
    }

    public QCRImageDao getQCRImageDao() {
        return qCRImageDao;
    }

}
