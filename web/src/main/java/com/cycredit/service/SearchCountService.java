package com.cycredit.service;

import com.cycredit.app.util.cache.pojo.UserInfo;
import com.cycredit.dao.entity.SearchCount;
import com.cycredit.dao.mapper.SearchCountMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by qiyubin on 2017/11/24 0024.
 *
 * @author qiyubin
 */
@Service
public class SearchCountService {

    @Resource
    SearchCountMapper searchCountMapper;

    public enum SearchType {
        person, enterprise;
    }

    public void saveCount(SearchType searchType, UserInfo userInfo) {
        SearchCount searchCount = new SearchCount();
        searchCount.setOperator(userInfo.getId());
        searchCount.setAreaCode(userInfo.getAreaCode());
        searchCount.setDepartmentCode(userInfo.getDepartmentCode());
        searchCount.setResult(1);
        searchCount.setCreateTime(new Date());
        searchCount.setSearchType(searchType.name());
        searchCountMapper.insertSelective(searchCount);
    }


}
