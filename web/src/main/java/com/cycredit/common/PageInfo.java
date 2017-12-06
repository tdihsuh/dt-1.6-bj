package com.cycredit.common;

/**
 * Created by qiyubin on 2017/12/6 0006.
 *
 * @author qiyubin
 */
public class PageInfo {

    private Integer pageNo;
    private Integer limitSize;

    private Long totalCount;


    private PageInfo() {
    }

    public PageInfo(Integer pageNo, Integer limitSize) {
        if (pageNo == null) {
            pageNo = 0;
        }
        if (limitSize == null) {
            limitSize = 10;
        } else {
            if (limitSize < 0) {
                limitSize = 1;
            } else if (limitSize > 20) {
                limitSize = 20;
            } else if (limitSize == 0) {
                limitSize = 10;
            }
        }

        this.pageNo = pageNo;
        this.limitSize = limitSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getOffset() {
        return this.pageNo * limitSize;
    }


    public Integer getLimitSize() {
        return limitSize;
    }

    public void setLimitSize(Integer limitSize) {
        this.limitSize = limitSize;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
