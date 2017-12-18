package com.cycredit.app.controller.credit.pojo.deal;

import com.cycredit.common.Tag;
import com.cycredit.dao.entity.EnterpriseDealResult;
import com.cycredit.dao.entity.PersonDealResult;
import com.cycredit.service.OriginService;
import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

/**
 * Created by qiyubin on 2017/12/14 0014.
 *
 * @author qiyubin
 */
public class PersonDealItem {

    private Long id;

    private String description;

    private String pid;

    private String name;

    private String identityCard;

    private String operatorName;

    private String dealType;

    private Date createTime;


    private List<Tag> tagList;


    public static PersonDealItem convertToThis(PersonDealResult personDealResult) {
        PersonDealItem personDealItem = new PersonDealItem();
        personDealItem.setId(personDealResult.getId());
        personDealItem.setPid(personDealResult.getPid());
        personDealItem.setIdentityCard(personDealResult.getIdentityCard());
        personDealItem.setCreateTime(personDealResult.getCreateTime());
        personDealItem.setDealType(personDealResult.getDealType());
        personDealItem.setDescription(personDealResult.getDescription());
        personDealItem.setName(personDealResult.getName());
        //todo 此处需要写活
        personDealItem.setOperatorName("操作员");

        List<Tag> list = Lists.newArrayList();
        for (String tag : personDealResult.getTags().split(",")) {
            Tag tagObj = OriginService.getTagByCode(tag);
            if (tagObj != null) {
                list.add(tagObj);
            }
        }
        personDealItem.setTagList(list);

        return personDealItem;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
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
