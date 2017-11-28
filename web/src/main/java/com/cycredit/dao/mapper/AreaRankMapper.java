package com.cycredit.dao.mapper;

import com.cycredit.dao.entity.AreaRank;
import com.cycredit.dao.entity.AreaRankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreaRankMapper {
    long countByExample(AreaRankExample example);

    int deleteByExample(AreaRankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AreaRank record);

    int insertSelective(AreaRank record);

    List<AreaRank> selectByExample(AreaRankExample example);

    AreaRank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AreaRank record, @Param("example") AreaRankExample example);

    int updateByExample(@Param("record") AreaRank record, @Param("example") AreaRankExample example);

    int updateByPrimaryKeySelective(AreaRank record);

    int updateByPrimaryKey(AreaRank record);
}