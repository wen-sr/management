package com.management.service.jc;

import com.management.pojo.jc.JiaoCaiContainerLoc;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/26 10:13
 * Modified By：
 */
public interface IJiaoCaiContainerLocService {

    void setLoc(String containerId, String loc);

    JiaoCaiContainerLoc getLoc(String containerId);
}
