package com.xing.manage.db;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;



/**
 * 临时巡检
 */
@Entity
public class CheckNow {
    @Id(autoincrement = true)
    private Long id;
    private String deviceName;//设备名称
    private String deviceGroup;//设备所属机组
    private String departmentName;//部门名称
    private String deviceKKS;//设备KKS码
    private String checkName;//设备名称
    @ToMany(referencedJoinProperty = "checkId")
    private List<Resource> resourceDaoList;//资源list
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1745973600)
    private transient CheckNowDao myDao;
    @Generated(hash = 497472852)
    public CheckNow(Long id, String deviceName, String deviceGroup,
            String departmentName, String deviceKKS, String checkName) {
        this.id = id;
        this.deviceName = deviceName;
        this.deviceGroup = deviceGroup;
        this.departmentName = departmentName;
        this.deviceKKS = deviceKKS;
        this.checkName = checkName;
    }
    @Generated(hash = 119871723)
    public CheckNow() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDeviceName() {
        return this.deviceName;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public String getDeviceGroup() {
        return this.deviceGroup;
    }
    public void setDeviceGroup(String deviceGroup) {
        this.deviceGroup = deviceGroup;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDeviceKKS() {
        return this.deviceKKS;
    }
    public void setDeviceKKS(String deviceKKS) {
        this.deviceKKS = deviceKKS;
    }
    public String getCheckName() {
        return this.checkName;
    }
    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 110178038)
    public List<Resource> getResourceDaoList() {
        if (resourceDaoList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ResourceDao targetDao = daoSession.getResourceDao();
            List<Resource> resourceDaoListNew = targetDao
                    ._queryCheckNow_ResourceDaoList(id);
            synchronized (this) {
                if (resourceDaoList == null) {
                    resourceDaoList = resourceDaoListNew;
                }
            }
        }
        return resourceDaoList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 718154733)
    public synchronized void resetResourceDaoList() {
        resourceDaoList = null;
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
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1964498783)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCheckNowDao() : null;
    }

}