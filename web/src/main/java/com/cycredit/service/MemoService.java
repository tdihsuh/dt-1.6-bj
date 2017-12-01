package com.cycredit.service;

import com.cycredit.dao.entity.UniMemo;
import com.cycredit.dao.entity.UniMemoDepartment;
import com.cycredit.dao.entity.UniMemoExample;
import com.cycredit.dao.mapper.UniMemoDepartmentMapper;
import com.cycredit.dao.mapper.UniMemoMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qiyubin on 2017/11/24 0024.
 *
 * @author qiyubin
 */
@Service
public class MemoService {

    @Resource
    UniMemoMapper uniMemoMapper;

    public void save(UniMemo uniMemo) {
        if (uniMemo.getId() == null) {
            uniMemoMapper.insertSelective(uniMemo);
        } else {
            uniMemoMapper.updateByPrimaryKeySelective(uniMemo);
        }

    }

    public List<UniMemo> findPublishMemo() {
        UniMemoExample uniMemoExample = new UniMemoExample();
        UniMemoExample.Criteria criteria = uniMemoExample.createCriteria().andStatusEqualTo(1);
        uniMemoExample.setOffset(0);
        uniMemoExample.setLimit(10);
        return uniMemoMapper.selectByExample(uniMemoExample);
    }

    public List<UniMemo> findPendingMemo() {
        UniMemoExample uniMemoExample = new UniMemoExample();
        UniMemoExample.Criteria criteria = uniMemoExample.createCriteria().andStatusEqualTo(0);
        uniMemoExample.setOffset(0);
        uniMemoExample.setLimit(10);
        return uniMemoMapper.selectByExample(uniMemoExample);
    }


    public List<UniMemo> findMyMemo(Long uid) {
        UniMemoExample uniMemoExample = new UniMemoExample();
        UniMemoExample.Criteria criteria = uniMemoExample.createCriteria().andOperatorEqualTo(uid);
        RowBounds rowBounds = new RowBounds(10, 0);

        uniMemoExample.setOffset(0);
        uniMemoExample.setLimit(10);
        return uniMemoMapper.selectByExample(uniMemoExample);
    }


}
