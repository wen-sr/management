package com.management.dao.ops;

import com.management.pojo.ops.ReContainerPickingShelfOrder;
import com.management.vo.ops.RPVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReContainerPickingShelfOrderMapper {
    int insert(ReContainerPickingShelfOrder record);

    int insertSelective(ReContainerPickingShelfOrder record);
    List<RPVo> getReContainerPickingShelfOrderData(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
}