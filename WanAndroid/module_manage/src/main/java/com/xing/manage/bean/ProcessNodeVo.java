package com.xing.manage.bean;

import java.util.List;

public class ProcessNodeVo {

    //节点id
    private String id;

    //节点名
    private String title;

    //节点类型 0开始 1用户任务 2结束 3排他网关")
    private Integer type;

    //todo 关联角色
     private List<Role> roles;

    //todo  关联用户
    private List<User> users;

    //todo 关联部门
    private List<Department> departments;

    //多级连续部门负责人
    private Boolean chooseDepHeader = false;

    //自选用户
    private Boolean customUser = false;

    //节点展开 前端所需
    private Boolean expand = true;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Boolean getChooseDepHeader() {
        return chooseDepHeader;
    }

    public void setChooseDepHeader(Boolean chooseDepHeader) {
        this.chooseDepHeader = chooseDepHeader;
    }

    public Boolean getCustomUser() {
        return customUser;
    }

    public void setCustomUser(Boolean customUser) {
        this.customUser = customUser;
    }

    public Boolean getExpand() {
        return expand;
    }

    public void setExpand(Boolean expand) {
        this.expand = expand;
    }
}
