package com.management.dao.prd1;

import com.management.pojo.prd1.PackBatchno;
import com.management.vo.prd1.GouBaoDataVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PackBatchnoMapper {
    int insert(PackBatchno record);

    int insertSelective(PackBatchno record);

    List<PackBatchno> getData(@Param("dd") String dd, @Param("id") String id);

    List<GouBaoDataVo> getGouBaoData(@Param("dd") String dd, @Param("id") String id);

    int gouBaoConfirm(@Param("dd") String dd, @Param("id") String id);
}