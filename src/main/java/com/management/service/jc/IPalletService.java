package com.management.service.jc;

import com.management.pojo.jc.JiaoCaiTask;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/25 15:02
 * Modified By：
 */
public interface IPalletService {
    public String sendToPallet(JiaoCaiTask jiaoCaiTask);
    public String sendToPalletOut(JiaoCaiTask jiaoCaiTask);
}
