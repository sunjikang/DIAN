package com.xing.module.quality.bean;


import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

/**
 * app_info 实体类
 */
public class AppInfo implements Serializable {

    private Long id;

    /**
     * 文件名称
     */
    private String appName;

    /**
     * 版本号
     */
    private String verCode;

    /**
     * 版本名
     */
    private String verName;

    /**
     * 上传时间
     */
    private Date upDate;

    /**
     * 描述
     */
    private String appDescribe;

    /**
     * 下载地址
     */
    private String downUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVerCode() {
        return verCode;
    }

    public void setVerCode(String verCode) {
        this.verCode = verCode;
    }

    public String getVerName() {
        return verName;
    }

    public void setVerName(String verName) {
        this.verName = verName;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public String getAppDescribe() {
        return appDescribe;
    }

    public void setAppDescribe(String appDescribe) {
        this.appDescribe = appDescribe;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", verCode='" + verCode + '\'' +
                ", verName='" + verName + '\'' +
                ", upDate=" + upDate +
                ", appDescribe='" + appDescribe + '\'' +
                ", downUrl='" + downUrl + '\'' +
                '}';
    }
}
