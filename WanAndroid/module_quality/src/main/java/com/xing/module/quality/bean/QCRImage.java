package com.xing.module.quality.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;

@Entity(nameInDb = "QCRImage")
public class QCRImage {
    @Id(autoincrement = true)
    private Long id;//F_ID	MES规则，主键
    @NotNull
    private Long qcrId;//品质ID	Y键关联QCRecord.QCID
    private String imageName;//图片名称 有后缀名	跟单ID+01（图片自增）
    private String imageUrl;//图片链接	/MKQC/uploadimages/20190831/（日期自建），文件服务器10.5.30.238
    private String imageLocalUrl;
    private String imageShowname;//图片显示名称 没有后缀名
    @Generated(hash = 1728365624)
    public QCRImage(Long id, @NotNull Long qcrId, String imageName, String imageUrl,
            String imageLocalUrl, String imageShowname) {
        this.id = id;
        this.qcrId = qcrId;
        this.imageName = imageName;
        this.imageUrl = imageUrl;
        this.imageLocalUrl = imageLocalUrl;
        this.imageShowname = imageShowname;
    }
    @Generated(hash = 976499625)
    public QCRImage() {
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
    public String getImageName() {
        return this.imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getImageLocalUrl() {
        return this.imageLocalUrl;
    }
    public void setImageLocalUrl(String imageLocalUrl) {
        this.imageLocalUrl = imageLocalUrl;
    }
    public String getImageShowname() {
        return this.imageShowname;
    }
    public void setImageShowname(String imageShowname) {
        this.imageShowname = imageShowname;
    }

}
