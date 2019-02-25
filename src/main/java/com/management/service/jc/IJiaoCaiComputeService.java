package com.management.service.jc;

import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiCompute;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/12 13:05
 * Modified By：
 */
public interface IJiaoCaiComputeService {
    ServerResponse getInfo(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute);

    ServerResponse cancelCompute(List<Long> ids);

    ServerResponse pickInfo(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute);

    ServerResponse wholeShipInfo(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute);

    ServerResponse wholeShipInfoTotal(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute);

    ServerResponse addBatchno(List<Long> ids);

    ServerResponse wholeShipInfoEnd(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute);

    ServerResponse cancel(List<Long> ids);

    ServerResponse pickInfoTotal(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute);

    ServerResponse startPick(List<Long> ids);

    ServerResponse confirmPick(List<Long> ids);

    ServerResponse oddPackTips(JiaoCaiCompute jiaoCaiCompute);

    ServerResponse oddPackInfo(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute);

    ServerResponse containeridBack(JiaoCaiCompute containerid);

    ServerResponse containeridMove(JiaoCaiCompute jiaoCaiCompute);
}
