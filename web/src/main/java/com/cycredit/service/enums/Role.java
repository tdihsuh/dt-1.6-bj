package com.cycredit.service.enums;

public enum Role {
    infoCenterEmployee("1", "信息中心职员"), infoCenterMajor("2", "信息中心主任"),
    dpEmployee("3", "部位职员"), dpMajor("4", "部位主任");

    String name;
    String code;

    Role(String code, String name) {
        this.name = name;
        this.code = code;
    }

    public static Role getRoleByCode(String code) {

        for (Role role : Role.values()) {
            if (role.code.equals(code)) {
                return role;
            }
        }
        return null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}