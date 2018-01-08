package com.cycredit.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cycredit.app.controller.credit.pojo.PersonItem;
import com.cycredit.common.Tag;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import springfox.documentation.service.Tags;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qiyubin on 2018/1/8 0008.
 *
 * @author qiyubin
 */
@Service
public class H3cService {

    @Resource
    OriginService originService;

    public static void main(String[] args) {
        String p = getPersonSimple("1");
        JSONObject jsonObject = JSON.parseObject(p);
        JSONObject entriesPersonSimple = jsonObject.getJSONObject("EntriesPersonSimple");
        JSONArray jsonArray = entriesPersonSimple.getJSONArray("EntryPersonSimple");
        //分析Category
        System.out.println(jsonArray.toJSONString());

    }

    public static PersonItem getPersonItem(String key) {
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
                name = temp.getString("INAME");
                identityCard = temp.getString("CARDNUM");
                String tag = temp.getString("CATEGORY");
                tags.add(tag);
                tagEntities.add(OriginService.getTagByCode(tag));
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
    public String getPersonFull(String key) {

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


    //http://ip:9763/services/ha_lhjc/ _get_person_simple?key=xx
    public String getEnterpriseSimple(String key) {

        return null;
    }


    //http://ip:9763/services/ha_lhjc/ _get_person_full?key=xx
    public String getEnterpriseFull(String key) {

        return null;
    }


}
