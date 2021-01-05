package com.xing.manage.db;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 资源
 */
@Entity
public class Resource {
    @Id(autoincrement = true)
    private Long id;
    private  String url;//资源手机本地url
    private  Boolean isUpdate;//上传状态 false未上传   true已上传
    private  Long checkId;//临时巡检项id
    @Generated(hash = 1779446767)
    public Resource(Long id, String url, Boolean isUpdate, Long checkId) {
        this.id = id;
        this.url = url;
        this.isUpdate = isUpdate;
        this.checkId = checkId;
    }
    @Generated(hash = 632359988)
    public Resource() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Boolean getIsUpdate() {
        return this.isUpdate;
    }
    public void setIsUpdate(Boolean isUpdate) {
        this.isUpdate = isUpdate;
    }
    public Long getCheckId() {
        return this.checkId;
    }
    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }
    

}
