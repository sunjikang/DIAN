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
import com.xing.manage.db.InspectionDao;
import com.xing.manage.db.FacilityDao;
@Entity
public class Facility implements Parcelable {
    public Long areaId;
    @Id(autoincrement = true)
    public Long  id;//         "id":"1326855914325676033",
    public String  createBy;//               "createBy":"admin",
    public String  createTime;//                "createTime":"2020-11-12 19:54:36",
    public String  updateBy;//                 "updateBy":"admin",
    public String  updateTime;//                 "updateTime":"2020-11-12 19:54:36",
    public String  delFlag;//                 "delFlag":0,
    public String  openStatus;//                 "openStatus":0,
    public String  code;//                "code":"EO_10GMP11AP001.A_QY-QJ01.JZ-01.TY",
    public String  name;//               "name":"#1机地下室A排污泵",
    public String  parentId;//               "parentId":"1323531636956074074",
    public String  kksCode;//                "kksCode":"10GMP11AP001",
    public String  isMain;//                "isMain":1,
    public String  type;//                "type":"三类设备",
    public String  scaleModel;//                "scaleModel":"65HLB-A",
    public String  productCompany;//               "productCompany":"江苏华电机械制造有限公司",
    public String  productTime;//               "productTime":"2020-11-12 19:54:36",
    public String  debugCompany;//               "debugCompany":null,
    public String  installNumber;//              "installNumber":1,
    public String  installPosition;//               "installPosition":"汽机房",
    public String  typeCode;//              "typeCode":"LX-B",
    public String  specialty;//              "specialty":"ZY-QJ",
    public String  sysCode;//              "sysCode":null,
    @ToMany(referencedJoinProperty = "facilityId")
    public List<Inspection> inspectionItemList;//              "inspectionItemList


    protected Facility(Parcel in) {
        if (in.readByte() == 0) {
            areaId = null;
        } else {
            areaId = in.readLong();
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
        code = in.readString();
        name = in.readString();
        parentId = in.readString();
        kksCode = in.readString();
        isMain = in.readString();
        type = in.readString();
        scaleModel = in.readString();
        productCompany = in.readString();
        productTime = in.readString();
        debugCompany = in.readString();
        installNumber = in.readString();
        installPosition = in.readString();
        typeCode = in.readString();
        specialty = in.readString();
        sysCode = in.readString();
        inspectionItemList = in.createTypedArrayList(Inspection.CREATOR);
    }

    @Generated(hash = 1002126246)
    public Facility(Long areaId, Long id, String createBy, String createTime, String updateBy,
            String updateTime, String delFlag, String openStatus, String code, String name,
            String parentId, String kksCode, String isMain, String type, String scaleModel,
            String productCompany, String productTime, String debugCompany,
            String installNumber, String installPosition, String typeCode, String specialty,
            String sysCode) {
        this.areaId = areaId;
        this.id = id;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delFlag = delFlag;
        this.openStatus = openStatus;
        this.code = code;
        this.name = name;
        this.parentId = parentId;
        this.kksCode = kksCode;
        this.isMain = isMain;
        this.type = type;
        this.scaleModel = scaleModel;
        this.productCompany = productCompany;
        this.productTime = productTime;
        this.debugCompany = debugCompany;
        this.installNumber = installNumber;
        this.installPosition = installPosition;
        this.typeCode = typeCode;
        this.specialty = specialty;
        this.sysCode = sysCode;
    }

    @Generated(hash = 1036448758)
    public Facility() {
    }

    public static final Creator<Facility> CREATOR = new Creator<Facility>() {
        @Override
        public Facility createFromParcel(Parcel in) {
            return new Facility(in);
        }

        @Override
        public Facility[] newArray(int size) {
            return new Facility[size];
        }
    };
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 2017034215)
    private transient FacilityDao myDao;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (areaId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(areaId);
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
        dest.writeString(code);
        dest.writeString(name);
        dest.writeString(parentId);
        dest.writeString(kksCode);
        dest.writeString(isMain);
        dest.writeString(type);
        dest.writeString(scaleModel);
        dest.writeString(productCompany);
        dest.writeString(productTime);
        dest.writeString(debugCompany);
        dest.writeString(installNumber);
        dest.writeString(installPosition);
        dest.writeString(typeCode);
        dest.writeString(specialty);
        dest.writeString(sysCode);
        dest.writeTypedList(inspectionItemList);
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getKksCode() {
        return this.kksCode;
    }

    public void setKksCode(String kksCode) {
        this.kksCode = kksCode;
    }

    public String getIsMain() {
        return this.isMain;
    }

    public void setIsMain(String isMain) {
        this.isMain = isMain;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScaleModel() {
        return this.scaleModel;
    }

    public void setScaleModel(String scaleModel) {
        this.scaleModel = scaleModel;
    }

    public String getProductCompany() {
        return this.productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public String getProductTime() {
        return this.productTime;
    }

    public void setProductTime(String productTime) {
        this.productTime = productTime;
    }

    public String getDebugCompany() {
        return this.debugCompany;
    }

    public void setDebugCompany(String debugCompany) {
        this.debugCompany = debugCompany;
    }

    public String getInstallNumber() {
        return this.installNumber;
    }

    public void setInstallNumber(String installNumber) {
        this.installNumber = installNumber;
    }

    public String getInstallPosition() {
        return this.installPosition;
    }

    public void setInstallPosition(String installPosition) {
        this.installPosition = installPosition;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSysCode() {
        return this.sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1269154927)
    public List<Inspection> getInspectionItemList() {
        if (inspectionItemList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            InspectionDao targetDao = daoSession.getInspectionDao();
            List<Inspection> inspectionItemListNew = targetDao
                    ._queryFacility_InspectionItemList(id);
            synchronized (this) {
                if (inspectionItemList == null) {
                    inspectionItemList = inspectionItemListNew;
                }
            }
        }
        return inspectionItemList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1883222590)
    public synchronized void resetInspectionItemList() {
        inspectionItemList = null;
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
    @Generated(hash = 341049285)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getFacilityDao() : null;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "areaId=" + areaId +
                ", id=" + id +
                ", createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", openStatus='" + openStatus + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", kksCode='" + kksCode + '\'' +
                ", isMain='" + isMain + '\'' +
                ", type='" + type + '\'' +
                ", scaleModel='" + scaleModel + '\'' +
                ", productCompany='" + productCompany + '\'' +
                ", productTime='" + productTime + '\'' +
                ", debugCompany='" + debugCompany + '\'' +
                ", installNumber='" + installNumber + '\'' +
                ", installPosition='" + installPosition + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", specialty='" + specialty + '\'' +
                ", sysCode='" + sysCode + '\'' +
                ", inspectionItemList=" + inspectionItemList +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                '}';
    }
}
