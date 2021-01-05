package com.xing.manage.bean.manage;

/**
 * 我的已完成的流程
 */
public class DoneBean {
  /*  applyer: "管理员"
    applyerUsername: "admin"
    assignee: null
    assignees: null
    businessKey: "1326480015013056512"
    category: null
    comment: null
    createTime: "2020-11-12 08:51:56"
    deleteReason: "发起人撤回-原因未填写"
    description: null
    dueTime: null
    duration: 1490811
    endTime: "2020-11-12 09:16:47"
    executionId: "197501"
    id: "197507"
    key: "sid-60F789CE-E8F8-4B4B-8124-E39A66FCCA35"
    name: "部门领导审核"
    owner: null
    ownerUsername: null
    priority: 0
    procDefId: "MaterialsSettlement:1:192507"
    procInstId: "197501"
    processName: "物资结算"
    routeName: "materialsSettlement"
    startTime: "2020-11-12 08:51:56"
    tableId: "1326480010625814528"
    version: 1
    workTime: null
   */
   private String applyer;
    private String  applyerUsername;
    private String  assignee;
    private String  assignees;
    private String  businessKey;
    private String   category;
    private String   comment;
    private String   createTime;
    private String   deleteReason;
    private String   description;
    private String   dueTime;
    private String   duration;
    private String   endTime;
    private String   executionId;
    private String   id;
    private String   key;
    private String    name;
    private String  owner;
    private String   ownerUsername;
    private Integer   priority;
    private String   procDefId;
    private String  procInstId;
    private String   processName;
    private String   routeName;
    private String  startTime;
    private String  tableId;
    private String  version;
    private String  workTime;

 public void setApplyer(String applyer) {
  this.applyer = applyer;
 }

 public void setApplyerUsername(String applyerUsername) {
  this.applyerUsername = applyerUsername;
 }

 public void setAssignee(String assignee) {
  this.assignee = assignee;
 }

 public void setAssignees(String assignees) {
  this.assignees = assignees;
 }

 public void setBusinessKey(String businessKey) {
  this.businessKey = businessKey;
 }

 public void setCategory(String category) {
  this.category = category;
 }

 public void setComment(String comment) {
  this.comment = comment;
 }

 public void setCreateTime(String createTime) {
  this.createTime = createTime;
 }

 public void setDeleteReason(String deleteReason) {
  this.deleteReason = deleteReason;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public void setDueTime(String dueTime) {
  this.dueTime = dueTime;
 }

 public void setDuration(String duration) {
  this.duration = duration;
 }

 public void setEndTime(String endTime) {
  this.endTime = endTime;
 }

 public void setExecutionId(String executionId) {
  this.executionId = executionId;
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

 public void setOwner(String owner) {
  this.owner = owner;
 }

 public void setOwnerUsername(String ownerUsername) {
  this.ownerUsername = ownerUsername;
 }

 public void setPriority(Integer priority) {
  this.priority = priority;
 }

 public void setProcDefId(String procDefId) {
  this.procDefId = procDefId;
 }

 public void setProcInstId(String procInstId) {
  this.procInstId = procInstId;
 }

 public void setProcessName(String processName) {
  this.processName = processName;
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

 public void setVersion(String version) {
  this.version = version;
 }

 public void setWorkTime(String workTime) {
  this.workTime = workTime;
 }

 public String getApplyer() {
  return applyer;
 }

 public String getApplyerUsername() {
  return applyerUsername;
 }

 public String getAssignee() {
  return assignee;
 }

 public String getAssignees() {
  return assignees;
 }

 public String getBusinessKey() {
  return businessKey;
 }

 public String getCategory() {
  return category;
 }

 public String getComment() {
  return comment;
 }

 public String getCreateTime() {
  return createTime;
 }

 public String getDeleteReason() {
  return deleteReason;
 }

 public String getDescription() {
  return description;
 }

 public String getDueTime() {
  return dueTime;
 }

 public String getDuration() {
  return duration;
 }

 public String getEndTime() {
  return endTime;
 }

 public String getExecutionId() {
  return executionId;
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

 public String getOwner() {
  return owner;
 }

 public String getOwnerUsername() {
  return ownerUsername;
 }

 public Integer getPriority() {
  return priority;
 }

 public String getProcDefId() {
  return procDefId;
 }

 public String getProcInstId() {
  return procInstId;
 }

 public String getProcessName() {
  return processName;
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

 public String getVersion() {
  return version;
 }

 public String getWorkTime() {
  return workTime;
 }

 @Override
 public String toString() {
  return "DoneResult{" +
          "applyer='" + applyer + '\'' +
          ", applyerUsername='" + applyerUsername + '\'' +
          ", assignee='" + assignee + '\'' +
          ", assignees='" + assignees + '\'' +
          ", businessKey='" + businessKey + '\'' +
          ", category='" + category + '\'' +
          ", comment='" + comment + '\'' +
          ", createTime='" + createTime + '\'' +
          ", deleteReason='" + deleteReason + '\'' +
          ", description='" + description + '\'' +
          ", dueTime='" + dueTime + '\'' +
          ", duration='" + duration + '\'' +
          ", endTime='" + endTime + '\'' +
          ", executionId='" + executionId + '\'' +
          ", id='" + id + '\'' +
          ", key='" + key + '\'' +
          ", name='" + name + '\'' +
          ", owner='" + owner + '\'' +
          ", ownerUsername='" + ownerUsername + '\'' +
          ", priority='" + priority + '\'' +
          ", procDefId='" + procDefId + '\'' +
          ", procInstId='" + procInstId + '\'' +
          ", processName='" + processName + '\'' +
          ", routeName='" + routeName + '\'' +
          ", startTime='" + startTime + '\'' +
          ", tableId='" + tableId + '\'' +
          ", version='" + version + '\'' +
          ", workTime='" + workTime + '\'' +
          '}';
 }
}
