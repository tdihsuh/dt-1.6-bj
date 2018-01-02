package com.cycredit.app.controller.credit.pojo.deal;

import com.cycredit.app.util.cache.UserInfoCache;
import com.cycredit.app.util.cache.pojo.UserInfo;
import com.cycredit.common.Tag;
import com.cycredit.dao.entity.EnterpriseDealResult;
import com.cycredit.dao.entity.User;
import com.cycredit.service.OriginService;
import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

/**
 * Created by qiyubin on 2017/12/14 0014.
 *
 * @author qiyubin
 */
public class EnterpriseDealItem {


    private Long id;

    private String description;

    private String eid;

    private String name;

    private String code;

    private String dealType;

    private String operatorName;

    private Date createTime;

    private List<Tag> tagList;


    public static EnterpriseDealItem convertToThis(EnterpriseDealResult enterpriseDealResult) {
        EnterpriseDealItem enterpriseDealItem = new EnterpriseDealItem();
        enterpriseDealItem.setId(enterpriseDealResult.getId());
        enterpriseDealItem.setEid(enterpriseDealResult.getEid());
        enterpriseDealItem.setCode(enterpriseDealResult.getCode());
        enterpriseDealItem.setCreateTime(enterpriseDealResult.getCreateTime());
        enterpriseDealItem.setDealType(enterpriseDealResult.getDealType());
        enterpriseDealItem.setDescription(enterpriseDealResult.getDescription());
        enterpriseDealItem.setName(enterpriseDealResult.getName());

        if (enterpriseDealResult.getOperator() != null) {
            UserInfo userInfo = UserInfoCache.getFromCache(enterpriseDealResult.getOperator().toString());
            if (userInfo != null)
                enterpriseDealItem.setOperatorName(userInfo.getName());
        }

        List<Tag> list = Lists.newArrayList();
        for (String tag : enterpriseDealResult.getTags().split(",")) {
            Tag tagObj = OriginService.getTagByCode(tag);
            if (tagObj != null) {
                list.add(tagObj);
            }
        }
        enterpriseDealItem.setTagList(list);

        return enterpriseDealItem;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
