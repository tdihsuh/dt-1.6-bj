package com.cycredit.dao.mapper;

import com.cycredit.dao.entity.PersonDealResult;
import com.cycredit.dao.entity.PersonDealResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonDealResultMapper {
    long countByExample(PersonDealResultExample example);

    int deleteByExample(PersonDealResultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PersonDealResult record);

    int insertSelective(PersonDealResult record);

    List<PersonDealResult> selectByExample(PersonDealResultExample example);

    PersonDealResult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PersonDealResult record, @Param("example") PersonDealResultExample example);

    int updateByExample(@Param("record") PersonDealResult record, @Param("example") PersonDealResultExample example);

    int updateByPrimaryKeySelective(PersonDealResult record);

    int updateByPrimaryKey(PersonDealResult record);
}