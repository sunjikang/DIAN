package com.xing.manage.bean.manage;

/***
 * 流程管理
 * http://101.200.140.188:8901/xboot/actProcess/getByCondition?showLatest=true&name=&processKey=&status=&pageNumber=1&pageSize=10&sort=createTime&order=desc&startDate=&endDate=
 */
public class ProgressManageBean {
   /*
   allUser: true
    businessTable: "mis_materials_settlement"
    categoryId: "1326479013333569536"
    categoryTitle: "物资结算"
    createBy: "admin"
    createTime: "2020-11-11 18:56:03"
    delFlag: 0
    deploymentId: "192504"
    description: ""
    diagramName: "物资结算.MaterialsSettlement.png"
    id: "MaterialsSettlement:1:192507"
    latest: true
    name: "物资结算"
    processKey: "MaterialsSettlement"
    routeName: "materialsSettlement"
    status: 1
    updateBy: "admin"
    updateTime: "2020-11-11 18:57:19"
    version: 1
    xmlName: "物资结算.bpmn20.xml"
    */

    private  Boolean  allUser;//: true
    private  String businessTable;//: "mis_materials_settlement"
    private  String categoryId;//: "1326479013333569536"
    private  String categoryTitle;//: "物资结算"
    private  String createBy;//: "admin"
    private  String createTime;//: "2020-11-11 18:56:03"
    private  Boolean delFlag;//: 0
    private  String deploymentId;//: "192504"
    private  String description;//: ""
    private  String  diagramName;//: "物资结算.MaterialsSettlement.png"
    private  String  id;//: "MaterialsSettlement:1:192507"
    private  Boolean latest;//: true
    private  String name;//: "物资结算"
    private  String  processKey;//: "MaterialsSettlement"
    private  String routeName;//: "materialsSettlement"
    private  Integer  status;//: 1
    private  String updateBy;//: "admin"
    private  String updateTime;//: "2020-11-11 18:57:19"
    private  Integer version;//: 1
    private  String xmlName;//: "物资结算.bpmn20.xml"

    @Override
    public String toString() {
        return "ProgressManageBean{" +
                "allUser=" + allUser +
                ", businessTable='" + businessTable + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", categoryTitle='" + categoryTitle + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", delFlag=" + delFlag +
                ", deploymentId='" + deploymentId + '\'' +
                ", description='" + description + '\'' +
                ", diagramName='" + diagramName + '\'' +
                ", id='" + id + '\'' +
                ", latest=" + latest +
                ", name='" + name + '\'' +
                ", processKey='" + processKey + '\'' +
                ", routeName='" + routeName + '\'' +
                ", status=" + status +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", version=" + version +
                ", xmlName='" + xmlName + '\'' +
                '}';
    }

    public Boolean getAllUser() {
        return allUser;
    }

    public String getBusinessTable() {
        return businessTable;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public String getDescription() {
        return description;
    }

    public String getDiagramName() {
        return diagramName;
    }

    public String getId() {
        return id;
    }

    public Boolean getLatest() {
        return latest;
    }

    public String getName() {
        return name;
    }

    public String getProcessKey() {
        return processKey;
    }

    public String getRouteName() {
        return routeName;
    }

    public Integer getStatus() {
        return status;
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

    public String getXmlName() {
        return xmlName;
    }

    public void setAllUser(Boolean allUser) {
        this.allUser = allUser;
    }

    public void setBusinessTable(String businessTable) {
        this.businessTable = businessTable;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDiagramName(String diagramName) {
        this.diagramName = diagramName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLatest(Boolean latest) {
        this.latest = latest;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }
}
