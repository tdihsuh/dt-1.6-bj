package com.cycredit.dao.mapper;

import com.cycredit.dao.entity.UniMemoDepartment;
import com.cycredit.dao.entity.UniMemoDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UniMemoDepartmentMapper {
    long countByExample(UniMemoDepartmentExample example);

    int deleteByExample(UniMemoDepartmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UniMemoDepartment record);

    int insertSelective(UniMemoDepartment record);

    List<UniMemoDepartment> selectByExample(UniMemoDepartmentExample example);

    UniMemoDepartment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UniMemoDepartment record, @Param("example") UniMemoDepartmentExample example);

    int updateByExample(@Param("record") UniMemoDepartment record, @Param("example") UniMemoDepartmentExample example);

    int updateByPrimaryKeySelective(UniMemoDepartment record);

    int updateByPrimaryKey(UniMemoDepartment record);
}