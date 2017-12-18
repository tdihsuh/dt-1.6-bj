package com.cycredit.app.controller.memo.pojo;

import java.util.List;

/**
 * Created by qiyubin on 2017/12/5 0005.
 *
 * @author qiyubin
 */
public class DepartmentItem {


    private Long memoId;
    private String departmentName;
    private String departmentCode;

    private List<DepartmentMergeItem> departmentMergeItemList;


    public Long getMemoId() {
        return memoId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setMemoId(Long memoId) {
        this.memoId = memoId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }


    public List<DepartmentMergeItem> getDepartmentMergeItemList() {
        return departmentMergeItemList;
    }

    public void setDepartmentMergeItemList(List<DepartmentMergeItem> departmentMergeItemList) {
        this.departmentMergeItemList = departmentMergeItemList;
    }
}
