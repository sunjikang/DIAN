package com.xing.manage.bean.device;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.xing.manage.db.DaoSession;
import com.xing.manage.db.FacilityDao;
import com.xing.manage.db.AreaDao;
@Entity
public class Area implements Parcelable {

    public Long lineId;
    @Id(autoincrement = true)
    public Long  id;//     "id":"1328154954527019008",
    public String  createBy;//             "createBy":"admin",
    public String  createTime;//           "createTime":"2020-11-16 09:56:31",
    public String  updateBy;//          "updateBy":"admin",
    public String  updateTime;//          "updateTime":"2020-11-16 09:56:31",
    public String  delFlag;//          "delFlag":0,
    public String  openStatus;//          "openStatus":0,
    public String  areaCode;//          "areaCode":"xjqy0021",
    public String  title;//          "title":"	 0021-巡检",
    public String  specialty;//         "specialty":"电气",
    public String  unit;//          "unit":"",
    public String  remark;//         "remark":"",
    public String  standbyI;//         "standbyI":"",
    public String  standbyII;//         "standbyII":"",
    public String  standbyIII;//          "standbyIII":"",
    @ToMany(referencedJoinProperty = "areaId")
    public List<Facility> facilityList;//          "facilityList":

    protected Area(Parcel in) {
        if (in.readByte() == 0) {
            lineId = null;
        } else {
            lineId = in.readLong();
        }
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        createBy = in.readString();
        createTime = in.readString();
        updateBy = in.readString();
        updateTime = in.readString();
        delFlag = in.readString();
        openStatus = in.readString();
        areaCode = in.readString();
        title = in.readString();
        specialty = in.readString();
        unit = in.readString();
        remark = in.readString();
        standbyI = in.readString();
        standbyII = in.readString();
        standbyIII = in.readString();
        facilityList = in.createTypedArrayList(Facility.CREATOR);
    }

    @Generated(hash = 1453466474)
    public Area(Long lineId, Long id, String createBy, String createTime,
            String updateBy, String updateTime, String delFlag, String openStatus,
            String areaCode, String title, String specialty, String unit,
            String remark, String standbyI, String standbyII, String standbyIII) {
        this.lineId = lineId;
        this.id = id;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delFlag = delFlag;
        this.openStatus = openStatus;
        this.areaCode = areaCode;
        this.title = title;
        this.specialty = specialty;
        this.unit = unit;
        this.remark = remark;
        this.standbyI = standbyI;
        this.standbyII = standbyII;
        this.standbyIII = standbyIII;
    }

    @Generated(hash = 179626505)
    public Area() {
    }

    public static final Creator<Area> CREATOR = new Creator<Area>() {
        @Override
        public Area createFromParcel(Parcel in) {
            return new Area(in);
        }

        @Override
        public Area[] newArray(int size) {
            return new Area[size];
        }
    };
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 2080275148)
    private transient AreaDao myDao;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (lineId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(lineId);
        }
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(createBy);
        dest.writeString(createTime);
        dest.writeString(updateBy);
        dest.writeString(updateTime);
        dest.writeString(delFlag);
        dest.writeString(openStatus);
        dest.writeString(areaCode);
        dest.writeString(title);
        dest.writeString(specialty);
        dest.writeString(unit);
        dest.writeString(remark);
        dest.writeString(standbyI);
        dest.writeString(standbyII);
        dest.writeString(standbyIII);
        dest.writeTypedList(facilityList);
    }

    public Long getLineId() {
        return this.lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getOpenStatus() {
        return this.openStatus;
    }

    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStandbyI() {
        return this.standbyI;
    }

    public void setStandbyI(String standbyI) {
        this.standbyI = standbyI;
    }

    public String getStandbyII() {
        return this.standbyII;
    }

    public void setStandbyII(String standbyII) {
        this.standbyII = standbyII;
    }

    public String getStandbyIII() {
        return this.standbyIII;
    }

    public void setStandbyIII(String standbyIII) {
        this.standbyIII = standbyIII;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1613573610)
    public List<Facility> getFacilityList() {
        if (facilityList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FacilityDao targetDao = daoSession.getFacilityDao();
            List<Facility> facilityListNew = targetDao._queryArea_FacilityList(id);
            synchronized (this) {
                if (facilityList == null) {
                    facilityList = facilityListNew;
                }
            }
        }
        return facilityList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 2120366010)
    public synchronized void resetFacilityList() {
        facilityList = null;
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
    @Generated(hash = 1631869529)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAreaDao() : null;
    }

    @Override
    public String toString() {
        return "Area{" +
                "lineId=" + lineId +
                ", id=" + id +
                ", createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", openStatus='" + openStatus + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", title='" + title + '\'' +
                ", specialty='" + specialty + '\'' +
                ", unit='" + unit + '\'' +
                ", remark='" + remark + '\'' +
                ", standbyI='" + standbyI + '\'' +
                ", standbyII='" + standbyII + '\'' +
                ", standbyIII='" + standbyIII + '\'' +
                ", facilityList=" + facilityList +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                '}';
    }
}