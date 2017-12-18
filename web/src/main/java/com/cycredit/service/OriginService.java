package com.cycredit.service;

import com.alibaba.fastjson.JSONObject;
import com.cycredit.app.util.cache.CacheService;
import com.cycredit.base.utils.cache.JedisUtils;
import com.cycredit.common.Tag;
import com.cycredit.dao.entity.Area;
import com.cycredit.dao.entity.AreaExample;
import com.cycredit.dao.entity.Department;
import com.cycredit.dao.entity.DepartmentExample;
import com.cycredit.dao.mapper.AreaMapper;
import com.cycredit.dao.mapper.DepartmentMapper;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by qiyubin on 2017/12/11 0011.
 *
 * @author qiyubin
 */
@Service
public class OriginService {

    @Resource
    DepartmentMapper departmentMapper;
    @Resource
    AreaMapper areaMapper;


    private static String AREA_CACHE = "origin:dict:area";

    private static String DEPARTMENT_CACHE = "origin:dict:department";

    private static String fetchCacheKey(String suffix, String uid) {

        return new StringBuffer(suffix).append(":").append(uid).toString();
    }

    public static Map<String, Tag> tagMap = Maps.newHashMap();

    static {
        tagMap.put("1", new Tag("1", "失信被执行人", "PUNISH"));
        tagMap.put("2", new Tag("2", "重大税收违法", "PUNISH"));
        tagMap.put("101", new Tag("101", "杰出贡献", "BONUS"));
    }


    public static Tag getTagByCode(String code) {
        return tagMap.get(code);
    }


    public Area getAreaByCode(String code) {
        String key = fetchCacheKey(AREA_CACHE, code);
        Area area = CacheService.getFromCache(key, Area.class);
        if (area == null) {
            AreaExample areaExample = new AreaExample();
            areaExample.createCriteria().andAreaCodeEqualTo(code);
            List<Area> areas = areaMapper.selectByExample(areaExample);
            if (CollectionUtils.isNotEmpty(areas)) {
                Area dbArea = areas.get(0);
                CacheService.setToCache(key, dbArea);
                area = dbArea;
            }
        }
        return area;
    }


    public Department getDepartment(String code) {
        String key = fetchCacheKey(DEPARTMENT_CACHE, code);
        Department department = CacheService.getFromCache(key, Department.class);
        if (department == null) {
            DepartmentExample departmentExample = new DepartmentExample();
            departmentExample.createCriteria().andDepartmentCodeEqualTo(code);
            List<Department> departments = departmentMapper.selectByExample(departmentExample);
            if (CollectionUtils.isNotEmpty(departments)) {
                Department dbDepartment = departments.get(0);
                CacheService.setToCache(key, dbDepartment);
                department = dbDepartment;
            }
        }
        return department;
    }
}
