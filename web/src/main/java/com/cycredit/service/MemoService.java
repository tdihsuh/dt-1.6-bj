package com.cycredit.service;

import com.cycredit.dao.entity.UniMemo;
import com.cycredit.dao.entity.UniMemoDepartment;
import com.cycredit.dao.mapper.UniMemoDepartmentMapper;
import com.cycredit.dao.mapper.UniMemoMapper;
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

        return null;
    }

    public List<UniMemo> findMyMemo() {

        return null;
    }


}
