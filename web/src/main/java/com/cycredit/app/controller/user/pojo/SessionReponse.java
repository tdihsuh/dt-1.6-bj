package com.cycredit.app.controller.user.pojo;

/**
 * Created by qiyubin on 2017/11/30 0030.
 *
 * @author qiyubin
 */
public class SessionReponse {


    public SessionReponse() {
    }


    public SessionReponse(Long id, String name, String departmentCode, String departmentName, String role, String roleName, String areaCode, String areaName) {
        this.id = id;
        this.name = name;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.role = role;
        this.roleName = roleName;
        this.areaCode = areaCode;
        this.areaName = areaName;
    }

    private Long id;
    private String name;
    private String departmentCode;
    private String departmentName;
    private String role;
    private String roleName;
    private String areaCode;
    private String areaName;

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

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
