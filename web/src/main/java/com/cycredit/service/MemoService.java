package com.cycredit.service;

import com.cycredit.common.PageInfo;
import com.cycredit.dao.entity.UniMemo;
import com.cycredit.dao.entity.UniMemoDepartment;
import com.cycredit.dao.entity.UniMemoDepartmentExample;
import com.cycredit.dao.entity.UniMemoExample;
import com.cycredit.dao.mapper.UniMemoDepartmentMapper;
import com.cycredit.dao.mapper.UniMemoMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.PublicKey;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by qiyubin on 2017/11/24 0024.
 *
 * @author qiyubin
 */
@Service
public class MemoService {

    @Resource
    UniMemoMapper uniMemoMapper;


    @Resource
    UniMemoDepartmentMapper uniMemoDepartmentMapper;


    //
    public Map<String, List<UniMemoDepartment>> findDepartmentMemoMap(String departmentCode) {
        UniMemoDepartmentExample uniMemoDepartmentExample = new UniMemoDepartmentExample();
        uniMemoDepartmentExample.createCriteria().andDepartmentCodeEqualTo(departmentCode);
        List<UniMemoDepartment> uniMemoDepartments = uniMemoDepartmentMapper.selectByExample(uniMemoDepartmentExample);
        Map<String, List<UniMemoDepartment>> map = Maps.newHashMap();
        for (UniMemoDepartment uniMemoDepartment : uniMemoDepartments) {
            List<UniMemoDepartment> temp = map.get(uniMemoDepartment.getMemoId().toString());
            if (CollectionUtils.isEmpty(temp)) {
                temp = Lists.newArrayList();
            }
            temp.add(uniMemoDepartment);
            map.put(uniMemoDepartment.getMemoId().toString(), temp);
        }


        return map;
    }


    public void save(UniMemo uniMemo) {
        if (uniMemo.getId() == null) {
            uniMemoMapper.insertSelective(uniMemo);
        } else {
            uniMemoMapper.updateByPrimaryKeySelective(uniMemo);
        }

    }

    public void publishMemo(Long id) {
        UniMemo uniMemo = new UniMemo();
        uniMemo.setId(id);
        uniMemo.setStatus(1);
        uniMemo.setUpdateTime(new Date());
        uniMemoMapper.updateByPrimaryKeySelective(uniMemo);
    }

    public void completeMemo(Long id) {
        UniMemo uniMemo = new UniMemo();
        uniMemo.setId(id);
        uniMemo.setStatus(0);
        uniMemo.setUpdateTime(new Date());
        uniMemoMapper.updateByPrimaryKeySelective(uniMemo);
    }

    public void backMemo(Long id) {
        UniMemo uniMemo = new UniMemo();
        uniMemo.setId(id);
        uniMemo.setStatus(-1);
        uniMemo.setUpdateTime(new Date());
        uniMemoMapper.updateByPrimaryKeySelective(uniMemo);
    }


    public UniMemo findById(Long id) {
        return uniMemoMapper.selectByPrimaryKey(id);
    }


    public List<UniMemo> findPublishMemo(PageInfo pageInfo) {
        UniMemoExample uniMemoExample = new UniMemoExample();
        UniMemoExample.Criteria criteria = uniMemoExample.createCriteria().andStatusEqualTo(1);
        pageInfo.setTotalCount(uniMemoMapper.countByExample(uniMemoExample));
        uniMemoExample.setOffset(pageInfo.getOffset());
        uniMemoExample.setLimit(pageInfo.getLimitSize());
        return uniMemoMapper.selectByExample(uniMemoExample);
    }

    public List<UniMemo> findPendingMemo(PageInfo pageInfo) {
        UniMemoExample uniMemoExample = new UniMemoExample();
        UniMemoExample.Criteria criteria = uniMemoExample.createCriteria().andStatusEqualTo(0);
        pageInfo.setTotalCount(uniMemoMapper.countByExample(uniMemoExample));
        uniMemoExample.setOffset(pageInfo.getOffset());
        uniMemoExample.setLimit(pageInfo.getLimitSize());
        return uniMemoMapper.selectByExample(uniMemoExample);
    }


    public List<UniMemo> findModifyMemo(PageInfo pageInfo) {
        UniMemoExample uniMemoExample = new UniMemoExample();
        UniMemoExample.Criteria criteria = uniMemoExample.createCriteria().andStatusEqualTo(-1);
        pageInfo.setTotalCount(uniMemoMapper.countByExample(uniMemoExample));
        uniMemoExample.setOffset(pageInfo.getOffset());
        uniMemoExample.setLimit(pageInfo.getLimitSize());
        return uniMemoMapper.selectByExample(uniMemoExample);
    }


}
