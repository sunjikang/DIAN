package com.xing.manage.bean;


import java.util.List;

/**
 * @author Exrickx
 */
public class ActPage<T> {

    List<T> content;

    Long totalElements;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }
}
