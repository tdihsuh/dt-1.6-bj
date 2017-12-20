package com.cycredit.app.controller.memo.pojo;

import java.security.KeyStore;
import java.util.List;

/**
 * Created by qiyubin on 2017/12/5 0005.
 *
 * @author qiyubin
 */
public class MemoDetail {

    private Long id;
    private String name;
    private String relationDepartment;
    private String type;
    private String tags;
    private Integer status;
    private List<DepartmentItem> departmentItems;


    public List<DepartmentItem> getDepartmentItems() {
        return departmentItems;
    }

    public void setDepartmentItems(List<DepartmentItem> departmentItems) {
        this.departmentItems = departmentItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationDepartment() {
        return relationDepartment;
    }

    public void setRelationDepartment(String relationDepartment) {
        this.relationDepartment = relationDepartment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
