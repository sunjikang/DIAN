package com.xing.manage.bean;


import java.math.BigDecimal;
import java.util.List;

public class Department {

    private static final long serialVersionUID = 1L;

    //部门名称")
    private String title;

    //父id")
    private String parentId;

    //是否为父节点(含子节点) 默认false")
    private Boolean isParent = false;

    //排序值")
    private BigDecimal sortOrder;

    //是否启用 0启用 -1禁用")
    private Integer status = 0;

    //父节点名称")
    private String parentTitle;

    //主负责人")
    private List<String> mainHeader;

    //副负责人")
    private List<String> viceHeader;
}