package com.xing.module.quality.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import com.xing.module.quality.db.DaoSession;
import com.xing.module.quality.db.PlanDao;
import com.xing.module.quality.db.PlanMonthDao;

@Entity(nameInDb = "PlanMonth")
public class PlanMonth {
    /**
     * Id主键自增
     */
    @Id(autoincrement = true)
    private Long id;

    /**
     * 月份
     */
    @NotNull
    private String month;

    /**
     * 月计划条数
     */
    @NotNull
    private int planCount;

    /**
     * 每个父亲对应的孩子列表
     */
    @ToMany(referencedJoinProperty = "monthId")
    private List<Plan> planList;

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 2076945517)
    private transient PlanMonthDao myDao;

    @Generated(hash = 1996829766)
    public PlanMonth(Long id, @NotNull String month, int planCount) {
        this.id = id;
        this.month = month;
        this.planCount = planCount;
    }

    @Generated(hash = 94422350)
    public PlanMonth() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getPlanCount() {
        return this.planCount;
    }

    public void setPlanCount(int planCount) {
        this.planCount = planCount;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 275495288)
    public List<Plan> getPlanList() {
        if (planList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlanDao targetDao = daoSession.getPlanDao();
            List<Plan> planListNew = targetDao._queryPlanMonth_PlanList(id);
            synchronized (this) {
                if (planList == null) {
                    planList = planListNew;
                }
            }
        }
        return planList;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 902278808)
    public synchronized void resetPlanList() {
        planList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1681217712)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPlanMonthDao() : null;
    }

    @Override
    public String toString() {
        return "PlanMonth{" +
                "id=" + id +
                ", month='" + month + '\'' +
                ", planCount=" + planCount +
                ", planList=" + planList +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                '}';
    }
}
