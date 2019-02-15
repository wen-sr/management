package com.management.service.jc;

import com.management.vo.jc.JiaoCaiComputeVo;

import java.util.List;
import java.util.Map;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/15 9:27
 * Modified By：
 */
public interface IJiaoCaiPrintService {
    Map<String, Object> wholeCaseList(String batchno);

    Map<String, Object> allocationList(String batchno);

    Map<String, Object> s_ticketList(String batchno);

    Map<String, Object> pickList(String pickno);

    Map<String, Object> oddCaseList(String batchno);

    JiaoCaiComputeVo oddTicketList(String batchno);

    List<JiaoCaiComputeVo> loadBatchno();

    List<JiaoCaiComputeVo> loadPickno();

}
