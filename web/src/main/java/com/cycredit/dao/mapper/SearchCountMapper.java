package com.cycredit.dao.mapper;

import com.cycredit.dao.entity.SearchCount;
import com.cycredit.dao.entity.SearchCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchCountMapper {
    long countByExample(SearchCountExample example);

    int deleteByExample(SearchCountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SearchCount record);

    int insertSelective(SearchCount record);

    List<SearchCount> selectByExample(SearchCountExample example);

    SearchCount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SearchCount record, @Param("example") SearchCountExample example);

    int updateByExample(@Param("record") SearchCount record, @Param("example") SearchCountExample example);

    int updateByPrimaryKeySelective(SearchCount record);

    int updateByPrimaryKey(SearchCount record);
}