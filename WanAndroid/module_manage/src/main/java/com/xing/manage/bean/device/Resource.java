package com.xing.manage.bean.device;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/***
 * 资源
 */
@Entity
public class Resource implements Parcelable  {
    @Id(autoincrement = true)
    public  Long mmid;
    public Long id;
    public Long recordId; //巡检项Id
    public String name;  //资源名称
    public String path; //本地资源路径
    public String resourceType;//资源类型  0图片  1 资源 2录音


    protected Resource(Parcel in) {
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
            recordId = null;
        } else {
            recordId = in.readLong();
        }
        name = in.readString();
        path = in.readString();
        resourceType = in.readString();
    }

    @Generated(hash = 1625787270)
    public Resource(Long mmid, Long id, Long recordId, String name, String path,
            String resourceType) {
        this.mmid = mmid;
        this.id = id;
        this.recordId = recordId;
        this.name = name;
        this.path = path;
        this.resourceType = resourceType;
    }

    @Generated(hash = 632359988)
    public Resource() {
    }

    public static final Creator<Resource> CREATOR = new Creator<Resource>() {
        @Override
        public Resource createFromParcel(Parcel in) {
            return new Resource(in);
        }

        @Override
        public Resource[] newArray(int size) {
            return new Resource[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
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
        if (recordId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(recordId);
        }
        dest.writeString(name);
        dest.writeString(path);
        dest.writeString(resourceType);
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

    public Long getRecordId() {
        return this.recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getResourceType() {
        return this.resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
}
