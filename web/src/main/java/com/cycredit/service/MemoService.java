package com.cycredit.service;

import com.cycredit.common.PageInfo;
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

    public void publishMemo(Long id) {
        UniMemo uniMemo = new UniMemo();
        uniMemo.setId(id);
        uniMemo.setStatus(1);
        uniMemoMapper.updateByPrimaryKeySelective(uniMemo);
    }

    public void completeMemo(Long id) {
        UniMemo uniMemo = new UniMemo();
        uniMemo.setId(id);
        uniMemo.setStatus(0);
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
