package com.management.service.jc;

import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiSku;
import com.management.vo.jc.JiaoCaiSkuVo;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/22 11:14
 * Modified By：
 */
public interface IJiaoCaiSkuService {
    ServerResponse findAll(Integer pageSize, Integer pageNum, JiaoCaiSkuVo jiaoCaiSku);

    ServerResponse add(JiaoCaiSku jiaoCaiSku);
}
