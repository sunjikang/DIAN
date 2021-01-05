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
import com.xing.manage.db.RecordDao;
import com.xing.manage.db.ResourceDao;

/**
 * 上传记录
 */
@Entity
public class Record implements Parcelable {
    @Id(autoincrement = true)
     public  Long mmid;
     public  Long id;
     public Long startTime;   //开始时间
     public Long endTime;     //结束时间
     public String checker;   //检测人员
     public String pollingType; //检测类型
     public String observedValue;  //具体检测值
     public String remark;    //备注
     public Boolean isNormal; //检测状态  正常  异常
     public Boolean isUploaded; //上传状态  未上传   已上传

    public Long lineId;//线路本地数据库Id
    public Long areaId;//区域本地数据库Id
    public Long facilityId;//设备本地数据库Id
    public Long inspectionId;//巡检项本地数据库Id

    public Long lineServerId;//线路服务器数据库Id
    public Long areaServerId;//区域服务器数据库Id
    public Long facilityServerId;//设备服务器数据库Id
    public Long inspectionServerId;//巡检项服务器数据库Id

    public String lineCode; //所在线路编码
    public String lineName; //所在线路名称
    public String areaName; //所在区域名称
    public String facilityName; //所在设备名称
    public String inspectionName; //所在巡检项名称


    @ToMany(referencedJoinProperty = "recordId")
    public List<Resource> resourceList; //资源list


    /**===========以下为自动生成代码*/


    protected Record(Parcel in) {
        if (in.readByte() == 0) {
            mmid = null;
        } else {
            mmid = in.readLong();
        }
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        if (in.readByte() == 0) {
            startTime = null;
        } else {
            startTime = in.readLong();
        }
        if (in.readByte() == 0) {
            endTime = null;
        } else {
            endTime = in.readLong();
        }
        checker = in.readString();
        pollingType = in.readString();
        observedValue = in.readString();
        remark = in.readString();
        byte tmpIsNormal = in.readByte();
        isNormal = tmpIsNormal == 0 ? null : tmpIsNormal == 1;
        byte tmpIsUploaded = in.readByte();
        isUploaded = tmpIsUploaded == 0 ? null : tmpIsUploaded == 1;
        if (in.readByte() == 0) {
            lineId = null;
        } else {
            lineId = in.readLong();
        }
        if (in.readByte() == 0) {
            areaId = null;
        } else {
            areaId = in.readLong();
        }
        if (in.readByte() == 0) {
            facilityId = null;
        } else {
            facilityId = in.readLong();
        }
        if (in.readByte() == 0) {
            inspectionId = null;
        } else {
            inspectionId = in.readLong();
        }
        if (in.readByte() == 0) {
            lineServerId = null;
        } else {
            lineServerId = in.readLong();
        }
        if (in.readByte() == 0) {
            areaServerId = null;
        } else {
            areaServerId = in.readLong();
        }
        if (in.readByte() == 0) {
            facilityServerId = null;
        } else {
            facilityServerId = in.readLong();
        }
        if (in.readByte() == 0) {
            inspectionServerId = null;
        } else {
            inspectionServerId = in.readLong();
        }
        lineCode = in.readString();
        lineName = in.readString();
        areaName = in.readString();
        facilityName = in.readString();
        inspectionName = in.readString();
        resourceList = in.createTypedArrayList(Resource.CREATOR);
    }

    @Generated(hash = 1864681263)
    public Record(Long mmid, Long id, Long startTime, Long endTime, String checker,
            String pollingType, String observedValue, String remark,
            Boolean isNormal, Boolean isUploaded, Long lineId, Long areaId,
            Long facilityId, Long inspectionId, Long lineServerId,
            Long areaServerId, Long facilityServerId, Long inspectionServerId,
            String lineCode, String lineName, String areaName, String facilityName,
            String inspectionName) {
        this.mmid = mmid;
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.checker = checker;
        this.pollingType = pollingType;
        this.observedValue = observedValue;
        this.remark = remark;
        this.isNormal = isNormal;
        this.isUploaded = isUploaded;
        this.lineId = lineId;
        this.areaId = areaId;
        this.facilityId = facilityId;
        this.inspectionId = inspectionId;
        this.lineServerId = lineServerId;
        this.areaServerId = areaServerId;
        this.facilityServerId = facilityServerId;
        this.inspectionServerId = inspectionServerId;
        this.lineCode = lineCode;
        this.lineName = lineName;
        this.areaName = areaName;
        this.facilityName = facilityName;
        this.inspectionName = inspectionName;
    }

    @Generated(hash = 477726293)
    public Record() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mmid == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(mmid);
        }
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        if (startTime == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(startTime);
        }
        if (endTime == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(endTime);
        }
        dest.writeString(checker);
        dest.writeString(pollingType);
        dest.writeString(observedValue);
        dest.writeString(remark);
        dest.writeByte((byte) (isNormal == null ? 0 : isNormal ? 1 : 2));
        dest.writeByte((byte) (isUploaded == null ? 0 : isUploaded ? 1 : 2));
        if (lineId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(lineId);
        }
        if (areaId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(areaId);
        }
        if (facilityId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(facilityId);
        }
        if (inspectionId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(inspectionId);
        }
        if (lineServerId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(lineServerId);
        }
        if (areaServerId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(areaServerId);
        }
        if (facilityServerId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(facilityServerId);
        }
        if (inspectionServerId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(inspectionServerId);
        }
        dest.writeString(lineCode);
        dest.writeString(lineName);
        dest.writeString(areaName);
        dest.writeString(facilityName);
        dest.writeString(inspectionName);
        dest.writeTypedList(resourceList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Long getMmid() {
        return this.mmid;
    }

    public void setMmid(Long mmid) {
        this.mmid = mmid;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getChecker() {
        return this.checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getPollingType() {
        return this.pollingType;
    }

    public void setPollingType(String pollingType) {
        this.pollingType = pollingType;
    }

    public String getObservedValue() {
        return this.observedValue;
    }

    public void setObservedValue(String observedValue) {
        this.observedValue = observedValue;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getIsNormal() {
        return this.isNormal;
    }

    public void setIsNormal(Boolean isNormal) {
        this.isNormal = isNormal;
    }

    public Boolean getIsUploaded() {
        return this.isUploaded;
    }

    public void setIsUploaded(Boolean isUploaded) {
        this.isUploaded = isUploaded;
    }

    public Long getLineId() {
        return this.lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getFacilityId() {
        return this.facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public Long getInspectionId() {
        return this.inspectionId;
    }

    public void setInspectionId(Long inspectionId) {
        this.inspectionId = inspectionId;
    }

    public Long getLineServerId() {
        return this.lineServerId;
    }

    public void setLineServerId(Long lineServerId) {
        this.lineServerId = lineServerId;
    }

    public Long getAreaServerId() {
        return this.areaServerId;
    }

    public void setAreaServerId(Long areaServerId) {
        this.areaServerId = areaServerId;
    }

    public Long getFacilityServerId() {
        return this.facilityServerId;
    }

    public void setFacilityServerId(Long facilityServerId) {
        this.facilityServerId = facilityServerId;
    }

    public Long getInspectionServerId() {
        return this.inspectionServerId;
    }

    public void setInspectionServerId(Long inspectionServerId) {
        this.inspectionServerId = inspectionServerId;
    }

    public String getLineCode() {
        return this.lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getLineName() {
        return this.lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getFacilityName() {
        return this.facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getInspectionName() {
        return this.inspectionName;
    }

    public void setInspectionName(String inspectionName) {
        this.inspectionName = inspectionName;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 404297703)
    public List<Resource> getResourceList() {
        if (resourceList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ResourceDao targetDao = daoSession.getResourceDao();
            List<Resource> resourceListNew = targetDao
                    ._queryRecord_ResourceList(mmid);
            synchronized (this) {
                if (resourceList == null) {
                    resourceList = resourceListNew;
                }
            }
        }
        return resourceList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 103441505)
    public synchronized void resetResourceList() {
        resourceList = null;
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
    @Generated(hash = 1505145191)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRecordDao() : null;
    }

    public static final Creator<Record> CREATOR = new Creator<Record>() {
        @Override
        public Record createFromParcel(Parcel in) {
            return new Record(in);
        }

        @Override
        public Record[] newArray(int size) {
            return new Record[size];
        }
    };
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 765166123)
    private transient RecordDao myDao;
}
