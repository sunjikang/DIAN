package com.xing.manage.bean.device;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public   class Inspection implements Parcelable {
    public Long facilityId;
    @Id(autoincrement = true)
    public Long  id;//      "id":"1329007301364944896",
    public String  createBy;//       "createBy":"admin",
    public String  createTime;//       "createTime":"2020-11-18 18:23:27",
    public String  updateBy;//       "updateBy":"admin",
    public String  updateTime;//       "updateTime":"2020-11-18 18:23:27",
    public String  delFlag;//       "delFlag":0,
    public String  openStatus;//       "openStatus":0,
    public String  inspectionItemName;//       "inspectionItemName":"阀门管线",
    public String  samplingNumber;//       "samplingNumber":"",
    public String  sampleFrequency;//             "sampleFrequency":"",
    public String  defaultSpeed;//      "defaultSpeed":"",
    public String  unit;//       "unit":"",
    public String  equipmentLevel;//      "equipmentLevel":"B类",
    public String  pollingType;//      "pollingType":"观察",
    public String  pollingStatus;//      "pollingStatus":"备用",
    public String  emissivity;//      "emissivity":"",
    public String  upperUp;//     "upperUp":"",
    public String  upper;//       "upper":"",
    public String  floor;//       "floor":"",
    public String  floorFl;//        "floorFl":"",
    public String  remark;//       "remark":"泄漏/关闭不严",
    public String  standbyI;//       "standbyI":"",
    public String  standbyII;//       "standbyII":"",
    public String  standbyIII;//       "standbyIII":""


    protected Inspection(Parcel in) {
        if (in.readByte() == 0) {
            facilityId = null;
        } else {
            facilityId = in.readLong();
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
        inspectionItemName = in.readString();
        samplingNumber = in.readString();
        sampleFrequency = in.readString();
        defaultSpeed = in.readString();
        unit = in.readString();
        equipmentLevel = in.readString();
        pollingType = in.readString();
        pollingStatus = in.readString();
        emissivity = in.readString();
        upperUp = in.readString();
        upper = in.readString();
        floor = in.readString();
        floorFl = in.readString();
        remark = in.readString();
        standbyI = in.readString();
        standbyII = in.readString();
        standbyIII = in.readString();
    }

    @Generated(hash = 469262609)
    public Inspection(Long facilityId, Long id, String createBy, String createTime,
            String updateBy, String updateTime, String delFlag, String openStatus,
            String inspectionItemName, String samplingNumber,
            String sampleFrequency, String defaultSpeed, String unit,
            String equipmentLevel, String pollingType, String pollingStatus,
            String emissivity, String upperUp, String upper, String floor,
            String floorFl, String remark, String standbyI, String standbyII,
            String standbyIII) {
        this.facilityId = facilityId;
        this.id = id;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delFlag = delFlag;
        this.openStatus = openStatus;
        this.inspectionItemName = inspectionItemName;
        this.samplingNumber = samplingNumber;
        this.sampleFrequency = sampleFrequency;
        this.defaultSpeed = defaultSpeed;
        this.unit = unit;
        this.equipmentLevel = equipmentLevel;
        this.pollingType = pollingType;
        this.pollingStatus = pollingStatus;
        this.emissivity = emissivity;
        this.upperUp = upperUp;
        this.upper = upper;
        this.floor = floor;
        this.floorFl = floorFl;
        this.remark = remark;
        this.standbyI = standbyI;
        this.standbyII = standbyII;
        this.standbyIII = standbyIII;
    }

    @Generated(hash = 56451862)
    public Inspection() {
    }

    public static final Creator<Inspection> CREATOR = new Creator<Inspection>() {
        @Override
        public Inspection createFromParcel(Parcel in) {
            return new Inspection(in);
        }

        @Override
        public Inspection[] newArray(int size) {
            return new Inspection[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (facilityId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(facilityId);
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
        dest.writeString(inspectionItemName);
        dest.writeString(samplingNumber);
        dest.writeString(sampleFrequency);
        dest.writeString(defaultSpeed);
        dest.writeString(unit);
        dest.writeString(equipmentLevel);
        dest.writeString(pollingType);
        dest.writeString(pollingStatus);
        dest.writeString(emissivity);
        dest.writeString(upperUp);
        dest.writeString(upper);
        dest.writeString(floor);
        dest.writeString(floorFl);
        dest.writeString(remark);
        dest.writeString(standbyI);
        dest.writeString(standbyII);
        dest.writeString(standbyIII);
    }

    public Long getFacilityId() {
        return this.facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
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

    public String getInspectionItemName() {
        return this.inspectionItemName;
    }

    public void setInspectionItemName(String inspectionItemName) {
        this.inspectionItemName = inspectionItemName;
    }

    public String getSamplingNumber() {
        return this.samplingNumber;
    }

    public void setSamplingNumber(String samplingNumber) {
        this.samplingNumber = samplingNumber;
    }

    public String getSampleFrequency() {
        return this.sampleFrequency;
    }

    public void setSampleFrequency(String sampleFrequency) {
        this.sampleFrequency = sampleFrequency;
    }

    public String getDefaultSpeed() {
        return this.defaultSpeed;
    }

    public void setDefaultSpeed(String defaultSpeed) {
        this.defaultSpeed = defaultSpeed;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getEquipmentLevel() {
        return this.equipmentLevel;
    }

    public void setEquipmentLevel(String equipmentLevel) {
        this.equipmentLevel = equipmentLevel;
    }

    public String getPollingType() {
        return this.pollingType;
    }

    public void setPollingType(String pollingType) {
        this.pollingType = pollingType;
    }

    public String getPollingStatus() {
        return this.pollingStatus;
    }

    public void setPollingStatus(String pollingStatus) {
        this.pollingStatus = pollingStatus;
    }

    public String getEmissivity() {
        return this.emissivity;
    }

    public void setEmissivity(String emissivity) {
        this.emissivity = emissivity;
    }

    public String getUpperUp() {
        return this.upperUp;
    }

    public void setUpperUp(String upperUp) {
        this.upperUp = upperUp;
    }

    public String getUpper() {
        return this.upper;
    }

    public void setUpper(String upper) {
        this.upper = upper;
    }

    public String getFloor() {
        return this.floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getFloorFl() {
        return this.floorFl;
    }

    public void setFloorFl(String floorFl) {
        this.floorFl = floorFl;
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

    @Override
    public String toString() {
        return "Inspection{" +
                "facilityId=" + facilityId +
                ", id=" + id +
                ", createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", openStatus='" + openStatus + '\'' +
                ", inspectionItemName='" + inspectionItemName + '\'' +
                ", samplingNumber='" + samplingNumber + '\'' +
                ", sampleFrequency='" + sampleFrequency + '\'' +
                ", defaultSpeed='" + defaultSpeed + '\'' +
                ", unit='" + unit + '\'' +
                ", equipmentLevel='" + equipmentLevel + '\'' +
                ", pollingType='" + pollingType + '\'' +
                ", pollingStatus='" + pollingStatus + '\'' +
                ", emissivity='" + emissivity + '\'' +
                ", upperUp='" + upperUp + '\'' +
                ", upper='" + upper + '\'' +
                ", floor='" + floor + '\'' +
                ", floorFl='" + floorFl + '\'' +
                ", remark='" + remark + '\'' +
                ", standbyI='" + standbyI + '\'' +
                ", standbyII='" + standbyII + '\'' +
                ", standbyIII='" + standbyIII + '\'' +
                '}';
    }
}

