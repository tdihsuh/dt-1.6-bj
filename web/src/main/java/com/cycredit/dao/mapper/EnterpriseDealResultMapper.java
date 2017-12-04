package com.cycredit.dao.mapper;

import com.cycredit.dao.entity.EnterpriseDealResult;
import com.cycredit.dao.entity.EnterpriseDealResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseDealResultMapper {
    long countByExample(EnterpriseDealResultExample example);

    int deleteByExample(EnterpriseDealResultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EnterpriseDealResult record);

    int insertSelective(EnterpriseDealResult record);

    List<EnterpriseDealResult> selectByExample(EnterpriseDealResultExample example);

    EnterpriseDealResult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EnterpriseDealResult record, @Param("example") EnterpriseDealResultExample example);

    int updateByExample(@Param("record") EnterpriseDealResult record, @Param("example") EnterpriseDealResultExample example);

    int updateByPrimaryKeySelective(EnterpriseDealResult record);

    int updateByPrimaryKey(EnterpriseDealResult record);
}