package com.xing.module.quality.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "QCCode")
public class QCCode {
    @Id(autoincrement = true)
    private Long id;
    private Long parentID;
    private String reasonName;
    private String enName;
    private Integer ReasonCode;

    @Generated(hash = 538581251)
    public QCCode(Long id, Long parentID, String reasonName, String enName,
            Integer ReasonCode) {
        this.id = id;
        this.parentID = parentID;
        this.reasonName = reasonName;
        this.enName = enName;
        this.ReasonCode = ReasonCode;
    }

    @Generated(hash = 878942353)
    public QCCode() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentID() {
        return parentID;
    }

    public void setParentID(Long parentID) {
        this.parentID = parentID;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public Integer getReasonCode() {
        return ReasonCode;
    }

    public void setReasonCode(Integer reasonCode) {
        ReasonCode = reasonCode;
    }
}
