package com.cycredit.dao.mapper;

import com.cycredit.dao.entity.UniMemo;
import com.cycredit.dao.entity.UniMemoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UniMemoMapper {
    long countByExample(UniMemoExample example);

    int deleteByExample(UniMemoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UniMemo record);

    int insertSelective(UniMemo record);

    List<UniMemo> selectByExample(UniMemoExample example);

    UniMemo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UniMemo record, @Param("example") UniMemoExample example);

    int updateByExample(@Param("record") UniMemo record, @Param("example") UniMemoExample example);

    int updateByPrimaryKeySelective(UniMemo record);

    int updateByPrimaryKey(UniMemo record);
}