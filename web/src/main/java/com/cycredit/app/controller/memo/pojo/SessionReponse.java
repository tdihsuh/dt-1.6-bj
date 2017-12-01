package com.cycredit.app.controller.memo.pojo;

/**
 * Created by qiyubin on 2017/11/30 0030.
 *
 * @author qiyubin
 */
public class SessionReponse {


    public SessionReponse() {
    }

    public SessionReponse(Long id, String name, String department, String departmentName, String role, String roleName, String area, String areaName) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.departmentName = departmentName;
        this.role = role;
        this.roleName = roleName;
        this.area = area;
        this.areaName = areaName;
    }

    private Long id;
    private String name;
    private String department;
    private String departmentName;
    private String role;
    private String roleName;
    private String area;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
