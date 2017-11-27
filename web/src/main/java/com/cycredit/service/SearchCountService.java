package com.cycredit.service;

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

    public void saveCount(SearchType searchType, Long uid, String area, Integer result) {
        SearchCount searchCount = new SearchCount();
        searchCount.setUid(uid);
        searchCount.setArea(area);
        searchCount.setResult(result);
        searchCount.setCreateTime(new Date());
        searchCount.setSearchType(searchType.name());
        searchCountMapper.insertSelective(searchCount);
    }


}
