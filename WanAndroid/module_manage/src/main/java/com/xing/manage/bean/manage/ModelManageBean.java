package com.xing.manage.bean.manage;

/**
 * 模型管理
 * http://101.200.140.188:8901/xboot/actModel/getByCondition?name=&modelKey=&pageNumber=1&pageSize=10&sort=createTime&order=desc
 */
public class ModelManageBean {
   /*
   createBy: "admin"
    createTime: "2020-11-11 18:53:13"
    delFlag: 0
    description: ""
    id: "192501"
    modelKey: "MaterialsSettlement"
    name: "物资结算"
    updateBy: "admin"
    updateTime: "2020-11-11 18:55:57"
    version: 2

    */

    @Override
    public String toString() {
        return "ModelManageBean{" +
                "createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", delFlag=" + delFlag +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", modelKey='" + modelKey + '\'' +
                ", name='" + name + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", version=" + version +
                '}';
    }

    private String  createBy;//: "admin"
    private String  createTime;//: "2020-11-11 18:53:13"
    private Integer  delFlag;//: 0
    private String  description;//: ""
    private String  id;//: "192501"
    private String  modelKey;//: "MaterialsSettlement"
    private String   name;//: "物资结算"
    private String   updateBy;//: "admin"
    private String  updateTime;//: "2020-11-11 18:55:57"
    private Integer   version;//: 2

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModelKey(String modelKey) {
        this.modelKey = modelKey;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getModelKey() {
        return modelKey;
    }

    public String getName() {
        return name;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public Integer getVersion() {
        return version;
    }
}
