package com.xing.module.quality.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;

@Entity(nameInDb = "QCRecordCode")
public class QCRecordCode {
    @Id(autoincrement = true)
    private Long id;//F_ID	MES规则，主键
    @NotNull
    private Long qcrId;//品质ID	Y键关联QCRecord.QCID
    private String reasonType;//不良类别
    private String reasonCode;//不良原因
    private Integer qty;//数量	不良代码数量，点击按钮+1，点击（-）清除，相同QCRecord记录多条不良代码记录分行记录
    @Generated(hash = 1562985841)
    public QCRecordCode(Long id, @NotNull Long qcrId, String reasonType,
            String reasonCode, Integer qty) {
        this.id = id;
        this.qcrId = qcrId;
        this.reasonType = reasonType;
        this.reasonCode = reasonCode;
        this.qty = qty;
    }
    @Generated(hash = 1215014221)
    public QCRecordCode() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getQcrId() {
        return this.qcrId;
    }
    public void setQcrId(Long qcrId) {
        this.qcrId = qcrId;
    }
    public String getReasonType() {
        return this.reasonType;
    }
    public void setReasonType(String reasonType) {
        this.reasonType = reasonType;
    }
    public String getReasonCode() {
        return this.reasonCode;
    }
    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }
    public Integer getQty() {
        return this.qty;
    }
    public void setQty(Integer qty) {
        this.qty = qty;
    }



}
