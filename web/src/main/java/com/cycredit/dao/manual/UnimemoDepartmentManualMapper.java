package com.cycredit.dao.manual;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by qiyubin on 2017/12/20 0020.
 *
 * @author qiyubin
 */
@Repository
public interface UnimemoDepartmentManualMapper {


    Integer selectMemoDepartmentCount(@Param("memoId") Long memoId);
}
