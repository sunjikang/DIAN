package com.xing.main.bean;

public class Model {
//    模块名称：name
//    模块编号：code
//    是否显示：isEnable
//    图片地址: urlImage
//    url地址:url
//    模块类别:isHtml（H5|非H5）
//            "id": "1343506729853390848",
//                    "createBy": "222222",
//                    "createTime": "2020-12-28 18:39:00",
//                    "updateBy": "222222",
//                    "updateTime": "2020-12-29 09:54:39",
//                    "delFlag": 0,
//                    "openStatus": 0,
//                    "modelName": "测试1",
//                    "modelCode": "a1001",
//                    "modelIsEnable": "是",
//                    "modelUrlImage": "www.jd.com",
//                    "modelUrl": "www.baidu.com",
//                    "modelIsHtml": "H5"
    public String name;
    public String code;
    public String url;
    public String urlImage;
    public Boolean isEnable;
    public Boolean isHtml;
    public String backgroundColor;
    public String textColor;

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", isEnable=" + isEnable +
                ", isHtml=" + isHtml +
                ", backgroundColor=" + backgroundColor +
                ", textColor=" + textColor +
                '}';
    }
}
