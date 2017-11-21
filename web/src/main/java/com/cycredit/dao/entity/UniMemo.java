package com.cycredit.dao.entity;

import java.io.Serializable;

public class UniMemo implements Serializable {
    private Long id;

    private String name;

    private String source;

    private String type;

    private String tag;

    private String relationDepartment;

    private Byte status;

    private static final long serialVersionUID = 1L;

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
        this.name = name == null ? null : name.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getRelationDepartment() {
        return relationDepartment;
    }

    public void setRelationDepartment(String relationDepartment) {
        this.relationDepartment = relationDepartment == null ? null : relationDepartment.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}