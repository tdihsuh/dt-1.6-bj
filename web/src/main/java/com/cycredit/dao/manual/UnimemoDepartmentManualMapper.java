package com.cycredit.dao.manual;

import com.cycredit.dao.entity.DepartmentRank;
import com.cycredit.dao.entity.UniMemoDepartment;
import com.cycredit.service.entity.DepartmentMemoId;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by qiyubin on 2017/12/20 0020.
 *
 * @author qiyubin
 */
@Repository
public interface UnimemoDepartmentManualMapper {


    void clearAreaRank();

    void clearDepartmentRank();

    DepartmentRank selectDepartmenRanktByDpCode(@Param("dpCode") String dpCode);

    Integer selectMemoDepartmentCount(@Param("memoId") Long memoId);

    List<DepartmentMemoId> selectDepartmentMemoIds();

}
