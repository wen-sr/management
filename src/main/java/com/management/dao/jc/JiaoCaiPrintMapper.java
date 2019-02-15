package com.management.dao.jc;

import com.management.vo.jc.JiaoCaiComputeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JiaoCaiPrintMapper {
    List<JiaoCaiComputeVo> getWholeCaseListHead(@Param("batchno") String batchno);

    List<JiaoCaiComputeVo> getWholeCaseListDetail(@Param("batchno") String batchno);

    List<JiaoCaiComputeVo> getAllocationList(String batchno);

    List<JiaoCaiComputeVo> getS_ticketList(String batchno);

    List<JiaoCaiComputeVo> getPickListHead(String pickno);

    List<JiaoCaiComputeVo> getPickListDetail(String pickno);

    List<JiaoCaiComputeVo> getOddCaseList(String batchno);

    List<JiaoCaiComputeVo> getOddCaseListHead(String batchno);

    List<JiaoCaiComputeVo> loadBatchno();

    List<JiaoCaiComputeVo> loadPickno();

}