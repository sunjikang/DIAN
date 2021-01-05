package com.xing.manage.bean.manage;

/**
 * 结束的流程
 * http://101.200.140.188:8901/xboot/actProcess/getFinishedProcess?name=&key=&pageNumber=1&pageSize=10
 */
public class FinishedBean {
 /*
    applyer: "管理员"
    applyerUsername: "admin"
    businessKey: "1326480015013056512"
    deleteReason: null
    deployId: "192504"
    description: null
    duration: 859986
    endTime: "2020-11-12 09:31:31"
    id: "200001"
    key: "MaterialsSettlement"
    name: "物质结算"
    procDefId: "MaterialsSettlement:1:192507"
    result: 2
    routeName: "materialsSettlement"
    startTime: "2020-11-12 09:17:11"
    tableId: "1326480010625814528"
    tenantId: ""
    version: 1
  */

    private String   applyer;//: "管理员"
    private String applyerUsername;//: "admin"
    private String  businessKey;//: "1326480015013056512"
    private String  deleteReason;//: null
    private String  deployId;//: "192504"
    private String  description;//: null
    private String  duration;//: 859986
    private String  endTime;//: "2020-11-12 09:31:31"
    private String id;//: "200001"
    private String key;//: "MaterialsSettlement"
    private String name;//: "物质结算"
    private String procDefId;//: "MaterialsSettlement:1:192507"
    private Integer result;//: 2
    private String routeName;//: "materialsSettlement"
    private String startTime;//: "2020-11-12 09:17:11"
    private String tableId;//: "1326480010625814528"
    private String  tenantId;//: ""
    private Integer  version;//: 1

    public void setApplyer(String applyer) {
        this.applyer = applyer;
    }

    public void setApplyerUsername(String applyerUsername) {
        this.applyerUsername = applyerUsername;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }

    public void setDeployId(String deployId) {
        this.deployId = deployId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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

    public String getApplyer() {
        return applyer;
    }

    public String getApplyerUsername() {
        return applyerUsername;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public String getDeployId() {
        return deployId;
    }

    public String getDescription() {
        return description;
    }

    public String getDuration() {
        return duration;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public Integer getResult() {
        return result;
    }

    public String getRouteName() {
        return routeName;
    }

    public String getStartTime() {
        return startTime;
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
        return "FinishedBean{" +
                "applyer='" + applyer + '\'' +
                ", applyerUsername='" + applyerUsername + '\'' +
                ", businessKey='" + businessKey + '\'' +
                ", deleteReason='" + deleteReason + '\'' +
                ", deployId='" + deployId + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", endTime='" + endTime + '\'' +
                ", id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", procDefId='" + procDefId + '\'' +
                ", result=" + result +
                ", routeName='" + routeName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", tableId='" + tableId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", version=" + version +
                '}';
    }


}
