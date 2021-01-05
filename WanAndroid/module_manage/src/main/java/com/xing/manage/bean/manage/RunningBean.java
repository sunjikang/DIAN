package com.xing.manage.bean.manage;

/**
 * 正在进行中的流程
 * http://101.200.140.188:8901/xboot/actProcess/getRunningProcess?name=&key=&pageNumber=1&pageSize=10
 */
public class RunningBean {
  /*
    actId: "sid-D90B30C3-B60D-4B46-8B02-17763538DCCE"
    applyer: "管理员"
    applyerUsername: "admin"
    businessKey: "1318369638752587776"
    currTaskName: "审核"
    deployId: "162507"
    description: null
    id: "187501"
    isSuspended: false
    key: "ticketWorkDq1"
    name: "电气一种工作票"
    parentId: null
    procDefId: "ticketWorkDq1:3:162510"
    procInstId: "187501"
    routeName: "ticketWorkDq1"
    tableId: "1318369638568038400"
    tenantId: ""
    version: 3
    */

   private  String  actId;//: "sid-D90B30C3-B60D-4B46-8B02-17763538DCCE"
    private String    applyer;//: "管理员"
    private String   applyerUsername;//: "admin"
    private String   businessKey;//: "1318369638752587776"
    private String    currTaskName;//: "审核"
    private String    deployId;//: "162507"
    private String   description;//: null
    private String  id;//: "187501"
    private Boolean   isSuspended;//: false
    private String   key;//: "ticketWorkDq1"
    private String   name;//: "电气一种工作票"
    private String   parentId;//: null
    private String    procDefId;//: "ticketWorkDq1:3:162510"
    private String    procInstId;//: "187501"
    private String   routeName;//: "ticketWorkDq1"
    private String   tableId;//: "1318369638568038400"
    private String   tenantId;//: ""
    private Integer   version;//: 3

    public void setActId(String actId) {
        this.actId = actId;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer;
    }

    public void setApplyerUsername(String applyerUsername) {
        this.applyerUsername = applyerUsername;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public void setCurrTaskName(String currTaskName) {
        this.currTaskName = currTaskName;
    }

    public void setDeployId(String deployId) {
        this.deployId = deployId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSuspended(Boolean suspended) {
        isSuspended = suspended;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getActId() {
        return actId;
    }

    public String getApplyer() {
        return applyer;
    }

    public String getApplyerUsername() {
        return applyerUsername;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public String getCurrTaskName() {
        return currTaskName;
    }

    public String getDeployId() {
        return deployId;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public Boolean getSuspended() {
        return isSuspended;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getParentId() {
        return parentId;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public String getRouteName() {
        return routeName;
    }

    public String getTableId() {
        return tableId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public Integer getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "RunningResultBean{" +
                "actId='" + actId + '\'' +
                ", applyer='" + applyer + '\'' +
                ", applyerUsername='" + applyerUsername + '\'' +
                ", businessKey='" + businessKey + '\'' +
                ", currTaskName='" + currTaskName + '\'' +
                ", deployId='" + deployId + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", isSuspended=" + isSuspended +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", procDefId='" + procDefId + '\'' +
                ", procInstId='" + procInstId + '\'' +
                ", routeName='" + routeName + '\'' +
                ", tableId='" + tableId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", version=" + version +
                '}';
    }
}
