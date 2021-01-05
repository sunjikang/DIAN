package com.xing.manage.bean.manage;


public class TodoBean {
    /**
     * {
     *     "id": "115007",
     *     "name": "审核",
     *     "key": "sid-63FE97B5-1E10-443F-8A34-FCD1DA862F65",
     *     "description": null,
     *     "executionId": "115001",
     *     "assignee": null,
     *     "owner": null,
     *     "ownerUsername": null,
     *     "procDefId": "ticketOperateDq:1:11",
     *     "procInstId": "115001",
     *     "applyer": "管理员",
     *     "applyerUsername": "admin",
     *     "category": null,
     *     "priority": 0,
     *     "isSuspended": false,
     *     "createTime": "2020-10-13 09:31:48",
     *     "processName": "电气操作票",
     *     "routeName": "ticketOperateDq",
     *     "businessKey": "1315827489066586112",
     *     "tableId": "1315827489028837376",
     *     "version": 1
     * }
     */
    private String id;
    private String name;
    private String key;
    private String description;
    private String executionId;
    private String assignee;
    private String owner;
    private String ownerUsername;
    private String procDefId;
    private String procInstId;
    private String applyer;
    private String applyerUsername;
    private String category;
    private Integer priority;
    private Boolean isSuspended;
    private String createTime;
    private String processName;
    private String routeNam;
    private String businessKey;
    private String tableId;
    private String version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getApplyer() {
        return applyer;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer;
    }

    public String getApplyerUsername() {
        return applyerUsername;
    }

    public void setApplyerUsername(String applyerUsername) {
        this.applyerUsername = applyerUsername;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getSuspended() {
        return isSuspended;
    }

    public void setSuspended(Boolean suspended) {
        isSuspended = suspended;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getRouteNam() {
        return routeNam;
    }

    public void setRouteNam(String routeNam) {
        this.routeNam = routeNam;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "TodoResult{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", description='" + description + '\'' +
                ", executionId='" + executionId + '\'' +
                ", assignee='" + assignee + '\'' +
                ", owner='" + owner + '\'' +
                ", ownerUsername='" + ownerUsername + '\'' +
                ", procDefId='" + procDefId + '\'' +
                ", procInstId='" + procInstId + '\'' +
                ", applyer='" + applyer + '\'' +
                ", applyerUsername='" + applyerUsername + '\'' +
                ", category='" + category + '\'' +
                ", priority=" + priority +
                ", isSuspended=" + isSuspended +
                ", createTime='" + createTime + '\'' +
                ", processName='" + processName + '\'' +
                ", routeNam='" + routeNam + '\'' +
                ", businessKey='" + businessKey + '\'' +
                ", tableId='" + tableId + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
