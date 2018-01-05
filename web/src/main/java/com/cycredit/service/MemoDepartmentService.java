package com.cycredit.service;

import com.cycredit.dao.entity.UniMemo;
import com.cycredit.dao.entity.UniMemoDepartment;
import com.cycredit.dao.entity.UniMemoDepartmentExample;
import com.cycredit.dao.manual.UnimemoDepartmentManualMapper;
import com.cycredit.dao.mapper.UniMemoDepartmentMapper;
import com.cycredit.dao.mapper.UniMemoMapper;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    @Resource
    UniMemoMapper uniMemoMapper;

    @Resource
    UnimemoDepartmentManualMapper unimemoDepartmentManualMapper;


    public UniMemoDepartment findMemoDepartmentById(Long id) {
        return uniMemoDepartmentMapper.selectByPrimaryKey(id);
    }

    public List<UniMemoDepartment> findMemoDepartment(Long memoId) {
        UniMemoDepartmentExample uniMemoDepartmentExample = new UniMemoDepartmentExample();
        uniMemoDepartmentExample.createCriteria().andMemoIdEqualTo(memoId);
        return uniMemoDepartmentMapper.selectByExample(uniMemoDepartmentExample);
    }


    public void updateUnimo(Long memnoId) {

        Integer count = unimemoDepartmentManualMapper.selectMemoDepartmentCount(memnoId);
        UniMemo uniMemo = new UniMemo();
        uniMemo.setId(memnoId);
        uniMemo.setDepartmentCount(count);
        uniMemo.setUpdateTime(new Date());
        uniMemoMapper.updateByPrimaryKeySelective(uniMemo);
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
