package com.cycredit.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cycredit.app.controller.credit.pojo.EnterpriseItem;
import com.cycredit.app.controller.credit.pojo.PersonItem;
import com.cycredit.app.controller.credit.pojo.detail.*;
import com.cycredit.common.Tag;
import com.cycredit.dao.entity.Department;
import com.cycredit.dao.entity.UniMemoDepartment;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by qiyubin on 2018/1/8 0008.
 *
 * @author qiyubin
 */
@Service
public class H3cService {

    @Resource
    OriginService originService;

    @Resource
    MemoService memoService;

    static final Map<String, CreditMemoEntry> supportMemo = Maps.newHashMap();

    {
        supportMemo.put("1", new CreditMemoEntry("1", "PUNISH", "失信被执行人", "法院", null, new Date()));
    }


    public static void main(String[] args) {
        String p = getPersonSimple("1");
        JSONObject jsonObject = JSON.parseObject(p);
        JSONObject entriesPersonSimple = jsonObject.getJSONObject("EntriesPersonSimple");
        JSONArray jsonArray = entriesPersonSimple.getJSONArray("EntryPersonSimple");
        //分析Category
        System.out.println(jsonArray.toJSONString());

    }

    public PersonItem getPersonItem(String key, String dpCode) {

        Map<String, List<UniMemoDepartment>> map = memoService.findDepartmentMemoMap(dpCode);

        try {
            PersonItem personItem = new PersonItem();
            String p = getPersonSimple(key);
            JSONObject jsonObject = JSON.parseObject(p);
            JSONObject entriesPersonSimple = jsonObject.getJSONObject("EntriesPersonSimple");
            JSONArray jsonArray = entriesPersonSimple.getJSONArray("EntryPersonSimple");
            String name = null;
            String identityCard = null;
            List<String> tags = Lists.newArrayList();
            List<Tag> tagEntities = Lists.newArrayList();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject temp = jsonArray.getJSONObject(i);
                String tag = temp.getString("CATEGORY");
                if (map.get(tag) == null) {
                    continue;
                }
                name = temp.getString("INAME");
                identityCard = temp.getString("CARDNUM");

                tags.add(tag);
                tagEntities.add(OriginService.getTagByCode(tag));
            }
            if (StringUtils.isEmpty(name)) {
                return null;
            }
            personItem.setName(name);
            personItem.setIdentityCard(identityCard);
            personItem.setTags(String.join(",", tags));
            personItem.setTagList(tagEntities);
            personItem.setPid(identityCard);
            return personItem;
        } catch (Exception e) {
            return null;
        }
    }

    public PersonDetail getPersonDetail(String key, String dpCode) {
        PersonDetail personDetail = new PersonDetail();
        Map<String, List<UniMemoDepartment>> map = memoService.findDepartmentMemoMap(dpCode);
        Department department = originService.getDepartment(dpCode);

        String p = getPersonFull(key);
        JSONObject jsonObject = JSON.parseObject(p);
        JSONObject entriesPersonFull = jsonObject.getJSONObject("EntriesPersonFull");
        JSONArray entryPersonFull = entriesPersonFull.getJSONArray("EntryPersonFull");
        String name = null;
        String identityCard = null;
        List<String> tags = Lists.newArrayList();
        List<Tag> tagEntities = Lists.newArrayList();

        //算标签 给出相应的惩罚
        List<CreditMemoEntry> memoEntryList = Lists.newArrayList();
        //同时把具体的触发事件记录下来
        List<EventDetail> eventDetailList = Lists.newArrayList();
        for (int i = 0; i < entryPersonFull.size(); i++) {
            JSONObject temp = entryPersonFull.getJSONObject(i);
            String category = temp.getString("CATEGORY");
            List<UniMemoDepartment> uniMemoDepartments = map.get(category);
            if (map.get(category) == null) {
                continue;
            }
            CreditMemoEntry tempMemo = supportMemo.get(category);


            List<MemoDepartmentItem> testUnimemoDeps = Lists.newArrayList();
            for (UniMemoDepartment uniMemoDepartment : uniMemoDepartments) {
                testUnimemoDeps.add(new MemoDepartmentItem(uniMemoDepartment.getReason(), uniMemoDepartment.getMeasure(), department.getDepartmentName()));
            }
            memoEntryList.add(new CreditMemoEntry(tempMemo.getMemoId(), tempMemo.getType(), tempMemo.getName(), tempMemo.getRelationDepartment(), testUnimemoDeps, new Date()));


            name = temp.getString("INAME");
            identityCard = temp.getString("CARDNUM");

            tags.add(category);
            tagEntities.add(OriginService.getTagByCode(category));
            //根据Category筛选

            EventDetail e1 = new EventDetail();
            //todo 根据事件算出具体的事件名称
            e1.setEventName(tempMemo.getName());
            List<CreditDetailEntry> detailEntryList = Lists.newArrayList();
            String details = temp.getString("DETAILS");
            JSONArray detailsJsonObject = JSONArray.parseArray(details);
            for (int j = 0; j < detailsJsonObject.size(); j++) {
                JSONObject jTemp = detailsJsonObject.getJSONObject(j);
                detailEntryList.add(new CreditDetailEntry(jTemp.getString("key"), jTemp.getString("value")));

            }
            e1.setEventDetail(detailEntryList);
            eventDetailList.add(e1);


        }

        PersonInfo personInfo = new PersonInfo(identityCard, name, identityCard, "", "");
        personDetail.setInfo(personInfo);

//        List<MemoDepartmentItem> testUnimemoDeps = Lists.newArrayList();
//        testUnimemoDeps.add(new MemoDepartmentItem("犯法", "法律110条", "人民法院"));
//        memoEntryList.add(new CreditMemoEntry(1L, "PUNISH", "企业联合执法", "法院", testUnimemoDeps, new Date()));
//
//        List<MemoDepartmentItem> testBonusUnimemoDeps = Lists.newArrayList();
//        testBonusUnimemoDeps.add(new MemoDepartmentItem("做好事", "好法110条", "人民法院"));
//        memoEntryList.add(new CreditMemoEntry(2L, "BONUS", "奖励备忘录", "法院", testBonusUnimemoDeps, new Date()));
        personDetail.setCreditMemoList(memoEntryList);


        personDetail.setCreditDetailList(eventDetailList);


        return personDetail;

    }


    //http://ip:9763/services/ha_lhjc/ _get_person_simple?key=xx
    public static String getPersonSimple(String key) {

        return "{\n" +
                "\t\"EntriesPersonSimple\": {\n" +
                "\t\t\"EntryPersonSimple\": [{\n" +
                "\t\t\t\"INAME\": \"张三\",\n" +
                "\t\t\t\"CARDNUM\": \"410402198911123212\",\n" +
                "\t\t\t\"CATEGORY\": \"1\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"INAME\": \"张三\",\n" +
                "\t\t\t\"CARDNUM\": \"410402198911123212\",\n" +
                "\t\t\t\"CATEGORY\": \"2\"\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}";
    }

    //http://ip:9763/services/ha_lhjc/ _get_person_full?key=xx
    public static String getPersonFull(String key) {

        return "{\n" +
                "\t\"EntriesPersonFull\": {\n" +
                "\t\t\"EntryPersonFull\": [{\n" +
                "\t\t\t\"INAME\": \"张三\",\n" +
                "\t\t\t\"AGE\": \"32\",\n" +
                "\t\t\t\"CARDNUM\": \"410402198911123212\",\n" +
                "\t\t\t\"CARDTYPE\": \"0\",\n" +
                "\t\t\t\"CATEGORY\": \"1\",\n" +
                "\t\t\t\"DETAILS\": \"[{\\\"key\\\":\\\"执行法院\\\",\\\"value\\\":\\\"河南郑州中级人民法院\\\"},{\\\"key\\\":\\\"地区\\\",\\\"value\\\":\\\"河南\\\"},{\\\"key\\\":\\\"执行依据文号\\\",\\\"value\\\":\\\"(2013)市领导反馈及案例三等奖法律手段\\\"},{\\\"key\\\":\\\"做出执行依据单位\\\",\\\"value\\\":\\\"郑州市人民法院\\\"},{\\\"key\\\":\\\"生效法律文书确定的义务\\\",\\\"value\\\":\\\"\\\"},{\\\"key\\\":\\\"履行情况\\\",\\\"value\\\":\\\"全部未履行\\\"},{\\\"key\\\":\\\"失信被执行人行为具体情形\\\",\\\"value\\\":\\\"其他有履行能力而拒不履行生效\\\"},{\\\"key\\\":\\\"登记时间\\\",\\\"value\\\":\\\"20131008\\\"},{\\\"key\\\":\\\"已履行\\\",\\\"value\\\":\\\"\\\"},{\\\"key\\\":\\\"未履行\\\",\\\"value\\\":\\\"\\\"}]\"}]}}";
    }


    public EnterpriseItem getEnterpriseItem(String key, String dpCode) {

        Map<String, List<UniMemoDepartment>> map = memoService.findDepartmentMemoMap(dpCode);

        try {
            EnterpriseItem enterpriseItem = new EnterpriseItem();
            String p = getEnterpriseSimple(key);
            JSONObject jsonObject = JSON.parseObject(p);
            JSONObject entriesPersonSimple = jsonObject.getJSONObject("EntriesEnterpriseSimple");
            JSONArray jsonArray = entriesPersonSimple.getJSONArray("EntryEnterpriseSimple");
            String name = null;
            String code = null;
            List<String> tags = Lists.newArrayList();
            List<Tag> tagEntities = Lists.newArrayList();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject temp = jsonArray.getJSONObject(i);
                String tag = temp.getString("CATEGORY");
                if (map.get(tag) == null) {
                    continue;
                }
                name = temp.getString("INAME");
                code = temp.getString("CARDNUM");

                tags.add(tag);
                tagEntities.add(OriginService.getTagByCode(tag));
            }
            if (StringUtils.isEmpty(name)) {
                return null;
            }
            enterpriseItem.setName(name);
            enterpriseItem.setCode(code);
            enterpriseItem.setTags(String.join(",", tags));
            enterpriseItem.setTagList(tagEntities);
            enterpriseItem.setEid(code);
            return enterpriseItem;
        } catch (Exception e) {
            return null;
        }
    }


    public EnterpriseDetail getEnterpriseDetail(String key, String dpCode) {
        EnterpriseDetail enterpriseDetail = new EnterpriseDetail();
        Map<String, List<UniMemoDepartment>> map = memoService.findDepartmentMemoMap(dpCode);
        Department department = originService.getDepartment(dpCode);

        String p = getEnterpriseFull(key);
        JSONObject jsonObject = JSON.parseObject(p);
        JSONObject entriesPersonFull = jsonObject.getJSONObject("EntriesEnterpriseFull");
        JSONArray entryPersonFull = entriesPersonFull.getJSONArray("EntryEnterpriseFull");


        String name = null;
        String code = null;
        String legal = null;
        String address = null;
        List<String> tags = Lists.newArrayList();
        List<Tag> tagEntities = Lists.newArrayList();

        //算标签 给出相应的惩罚
        List<CreditMemoEntry> memoEntryList = Lists.newArrayList();
        //同时把具体的触发事件记录下来
        List<EventDetail> eventDetailList = Lists.newArrayList();
        for (int i = 0; i < entryPersonFull.size(); i++) {
            JSONObject temp = entryPersonFull.getJSONObject(i);
            String category = temp.getString("CATEGORY");
            List<UniMemoDepartment> uniMemoDepartments = map.get(category);
            if (map.get(category) == null) {
                continue;
            }
            CreditMemoEntry tempMemo = supportMemo.get(category);


            List<MemoDepartmentItem> testUnimemoDeps = Lists.newArrayList();
            for (UniMemoDepartment uniMemoDepartment : uniMemoDepartments) {
                testUnimemoDeps.add(new MemoDepartmentItem(uniMemoDepartment.getReason(), uniMemoDepartment.getMeasure(), department.getDepartmentName()));
            }
            memoEntryList.add(new CreditMemoEntry(tempMemo.getMemoId(), tempMemo.getType(), tempMemo.getName(), tempMemo.getRelationDepartment(), testUnimemoDeps, new Date()));


            name = temp.getString("INAME");
            code = temp.getString("CARDNUM");
            legal = temp.getString("BUESINESSENTITY");
            address = temp.getString("REGADD");

            tags.add(category);
            tagEntities.add(OriginService.getTagByCode(category));
            //根据Category筛选

            EventDetail e1 = new EventDetail();
            //todo 根据事件算出具体的事件名称
            e1.setEventName(tempMemo.getName());
            List<CreditDetailEntry> detailEntryList = Lists.newArrayList();
            String details = temp.getString("DETAILS");
            JSONArray detailsJsonObject = JSONArray.parseArray(details);
            for (int j = 0; j < detailsJsonObject.size(); j++) {
                JSONObject jTemp = detailsJsonObject.getJSONObject(j);
                detailEntryList.add(new CreditDetailEntry(jTemp.getString("key"), jTemp.getString("value")));

            }
            e1.setEventDetail(detailEntryList);
            eventDetailList.add(e1);


        }

        EnterpriseInfo enterpriseInfo = new EnterpriseInfo(code, code, name, legal, null, address, null, null);
        enterpriseDetail.setInfo(enterpriseInfo);

//        List<MemoDepartmentItem> testUnimemoDeps = Lists.newArrayList();
//        testUnimemoDeps.add(new MemoDepartmentItem("犯法", "法律110条", "人民法院"));
//        memoEntryList.add(new CreditMemoEntry(1L, "PUNISH", "企业联合执法", "法院", testUnimemoDeps, new Date()));
//
//        List<MemoDepartmentItem> testBonusUnimemoDeps = Lists.newArrayList();
//        testBonusUnimemoDeps.add(new MemoDepartmentItem("做好事", "好法110条", "人民法院"));
//        memoEntryList.add(new CreditMemoEntry(2L, "BONUS", "奖励备忘录", "法院", testBonusUnimemoDeps, new Date()));
        enterpriseDetail.setCreditMemoList(memoEntryList);
        enterpriseDetail.setCreditDetailList(eventDetailList);


        return enterpriseDetail;

    }


    //http://ip:9763/services/ha_lhjc/ _get_person_simple?key=xx
    public String getEnterpriseSimple(String key) {

        return "{\n" +
                "\t\"EntriesEnterpriseSimple\": {\n" +
                "\t\t\"EntryEnterpriseSimple\": [{\n" +
                "\t\t\t\"INAME\": \"郑州金力农产品公司\",\n" +
                "\t\t\t\"CARDNUM\": \"57962715-1\",\n" +
                "\t\t\t\"CATEGORY\": \"1\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"INAME\": \"郑州金力农产品公司\",\n" +
                "\t\t\t\"CARDNUM\": \"57962715-1\",\n" +
                "\t\t\t\"CATEGORY\": \"2\"\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}";
    }


    //http://ip:9763/services/ha_lhjc/ _get_person_full?key=xx
    public String getEnterpriseFull(String key) {

        return "{\n" +
                "\t\"EntriesEnterpriseFull\": {\n" +
                "\t\t\"EntryEnterpriseFull\": [{\n" +
                "\t\t\t\"INAME\": \"郑州金力农产品公司\",\n" +
                "\t\t\t\"CARDNUM\": \"57962715-1\",\n" +
                "\t\t\t\"UNISCID\": null,\n" +
                "\t\t\t\"BUESINESSENTITY\": \"李四\",\n" +
                "\t\t\t\"TAXIDNUM\": null,\n" +
                "\t\t\t\"REGADD\": null,\n" +
                "\t\t\t\"BUESINESSENTITYTYPE\": null,\n" +
                "\t\t\t\"BUESINESSENTITYNUM\": null,\n" +
                "\t\t\t\"CATEGORY\": \"1\",\n" +
                "\t\t\t\"DETAILS\": \"[{\\\"key\\\":\\\"执行法院\\\",\\\"value\\\":\\\"河南高级级人民法院\\\"},{\\\"key\\\":\\\"地区\\\",\\\"value\\\":\\\"河南\\\"},{\\\"key\\\":\\\"执行依据文号\\\",\\\"value\\\":\\\"(2014)市领导反馈及案例三等奖法律手段\\\"},{\\\"key\\\":\\\"做出执行依据单位\\\",\\\"value\\\":\\\"郑州市人民法院\\\"},{\\\"key\\\":\\\"生效法律文书确定的义务\\\",\\\"value\\\":\\\"\\\"},{\\\"key\\\":\\\"履行情况\\\",\\\"value\\\":\\\"全部未履行\\\"},{\\\"key\\\":\\\"失信被执行人行为具体情形\\\",\\\"value\\\":\\\"其他有履行能力而拒不履行生效\\\"},{\\\"key\\\":\\\"登记时间\\\",\\\"value\\\":\\\"20131008\\\"},{\\\"key\\\":\\\"已履行\\\",\\\"value\\\":\\\"\\\"},{\\\"key\\\":\\\"未履行\\\",\\\"value\\\":\\\"\\\"}]\"},{\"INAME\": \"郑州金力农产品公司\",\"CARDNUM\": \"57962715-1\",\"UNISCID\": null,\"BUESINESSENTITY\": \"张有才\",\"TAXIDNUM\": \"211282318742709\",\"REGADD\": \"河南省郑州市花园路32号\",\"BUESINESSENTITYTYPE\": null,\"BUESINESSENTITYNUM\": \"410*********295751\",\"CATEGORY\": \"2\",\"DETAILS\":\"[{\\\"key\\\":\\\"直接财务负责人姓名\\\",\\\"value\\\":\\\"\\\"},{\\\"key\\\":\\\"财务负责人证件类型\\\",\\\"value\\\":\\\"\\\"},{\\\"key\\\":\\\"财务负责人证件号码\\\",\\\"value\\\":\\\"\\\"},{\\\"key\\\":\\\"中介机构从业人员情况\\\",\\\"value\\\":\\\"\\\"},{\\\"key\\\":\\\"案件性质\\\",\\\"value\\\":\\\"\\\"},{\\\"key\\\":\\\"主要违法事实\\\",\\\"value\\\":\\\"偷税漏税\\\"},{\\\"key\\\":\\\"法律依据和处罚情况\\\",\\\"value\\\":\\\"经过河南省郑州市税务局确认收到了福建省领导看风景圣诞快乐副书记的分类考试\\\"}]\"}]}}";
    }


}
