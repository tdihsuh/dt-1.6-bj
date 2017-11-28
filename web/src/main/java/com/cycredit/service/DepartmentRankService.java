package com.cycredit.service;

import com.cycredit.dao.entity.AreaRank;
import com.cycredit.dao.entity.AreaRankExample;
import com.cycredit.dao.entity.DepartmentRank;
import com.cycredit.dao.entity.DepartmentRankExample;
import com.cycredit.dao.mapper.AreaRankMapper;
import com.cycredit.dao.mapper.DepartmentRankMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qiyubin on 2017/11/28 0028.
 *
 * @author qiyubin
 */
@Service
public class DepartmentRankService {

    @Resource
    DepartmentRankMapper departmentRankMapper;


    public List<DepartmentRank> findAll() {
        DepartmentRankExample departmentRankExample = new DepartmentRankExample();
        departmentRankExample.setOrderByClause("rank asc");

        return departmentRankMapper.selectByExample(departmentRankExample);
    }


}
