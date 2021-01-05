package com.xing.manage.bean;


public class Role {

    //角色名 以ROLE_开头")
    private String name;

    //是否为注册默认角色")
    private Boolean defaultRole;

    //数据权限类型 0全部默认 1自定义 2本部门及以下 3本部门 4仅本人")
    private Integer dataType = 0;

    //备注")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(Boolean defaultRole) {
        this.defaultRole = defaultRole;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
