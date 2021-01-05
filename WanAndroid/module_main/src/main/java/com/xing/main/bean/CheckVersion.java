package com.xing.main.bean;

/**
 * 版本更新
 */
public class CheckVersion {

//    {
//        "success": true,
//            "message": "success",
//            "code": 200,
//            "timestamp": 1605075785748,
//            "result": {
//                 "id": "1325993356173643777",
//                "createBy": "st",
//                "createTime": "2020-11-10 10:47:06",
//                "updateBy": "caojian",
//                "updateTime": "2020-11-11 11:12:54",
//                "delFlag": 0,
//                "versionName": "1.0.1",
//                "versionNumber": 2,
//                "updateInstructions": "",
//                "isConstrainted": "是",
//                "apkFiles": "BaiduYunGuanjia_7.0.2.9.exe",
//                "apkFileSize": "64.35M",
//                "url": "http://101.200.140.188:8900/xboot/file/view/1325993684298240001",
//                "downloadTimes": 1
//    }
//    }
    public String downloadTimes;
    public String url;
    public String apkFileSize;
    public String createBy;
    public String apkFiles;
    public String isConstrainted;
    public String updateInstructions;
    public String versionNumber;
    public String versionName;
    public String delFlag;
    public String updateTime;
    public String updateBy;
    public String createTime;
    public String id;

    @Override
    public String toString() {
        return "CheckVersion{" +
                "downloadTimes='" + downloadTimes + '\'' +
                ", url='" + url + '\'' +
                ", apkFileSize='" + apkFileSize + '\'' +
                ", createBy='" + createBy + '\'' +
                ", apkFiles='" + apkFiles + '\'' +
                ", isConstrainted='" + isConstrainted + '\'' +
                ", updateInstructions='" + updateInstructions + '\'' +
                ", versionNumber='" + versionNumber + '\'' +
                ", versionName='" + versionName + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
