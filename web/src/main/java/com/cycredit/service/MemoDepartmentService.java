package com.cycredit.service;

import com.cycredit.dao.entity.UniMemoDepartment;
import com.cycredit.dao.entity.UniMemoDepartmentExample;
import com.cycredit.dao.mapper.UniMemoDepartmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qiyubin on 2017/11/24 0024.
 *
 * @author qiyubin
 */
@Service
public class MemoDepartmentService {

    @Resource
    UniMemoDepartmentMapper uniMemoDepartmentMapper;

    public List<UniMemoDepartment> findMemoDepartment(Long memoId) {
        UniMemoDepartmentExample uniMemoDepartmentExample = new UniMemoDepartmentExample();
        uniMemoDepartmentExample.createCriteria().andMemoIdEqualTo(memoId);
        return uniMemoDepartmentMapper.selectByExample(uniMemoDepartmentExample);
    }


    public void saveDepartment(UniMemoDepartment uniMemoDepartment) {
        if (uniMemoDepartment.getId() != null) {
            uniMemoDepartmentMapper.updateByPrimaryKeySelective(uniMemoDepartment);
        } else {
            uniMemoDepartmentMapper.insertSelective(uniMemoDepartment);
        }
        return;
    }

    public void deleteDepartment(Long id) {
        uniMemoDepartmentMapper.deleteByPrimaryKey(id);
    }


}
