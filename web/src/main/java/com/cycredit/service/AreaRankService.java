package com.cycredit.service;

import com.cycredit.dao.entity.AreaRank;
import com.cycredit.dao.entity.AreaRankExample;
import com.cycredit.dao.mapper.AreaRankMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qiyubin on 2017/11/28 0028.
 *
 * @author qiyubin
 */
@Service
public class AreaRankService {



    @Resource
    AreaRankMapper areaRankMapper;

    public List<AreaRank> findAll() {
        AreaRankExample areaRankExample = new AreaRankExample();
        areaRankExample.setOrderByClause("rank asc");

        return areaRankMapper.selectByExample(areaRankExample);
    }


}
