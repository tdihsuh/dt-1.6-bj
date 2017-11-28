package com.cycredit.dao.mapper;

import com.cycredit.dao.entity.DepartmentRank;
import com.cycredit.dao.entity.DepartmentRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentRankMapper {
    long countByExample(DepartmentRankExample example);

    int deleteByExample(DepartmentRankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DepartmentRank record);

    int insertSelective(DepartmentRank record);

    List<DepartmentRank> selectByExample(DepartmentRankExample example);

    DepartmentRank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DepartmentRank record, @Param("example") DepartmentRankExample example);

    int updateByExample(@Param("record") DepartmentRank record, @Param("example") DepartmentRankExample example);

    int updateByPrimaryKeySelective(DepartmentRank record);

    int updateByPrimaryKey(DepartmentRank record);
}