package com.management.service.report;

import com.management.common.ServerResponse;
import com.management.vo.xgw.XgwVo;


public interface IXiuGWService {
    ServerResponse cx(XgwVo xgwVo);
    ServerResponse go(XgwVo xgwVo);
    ServerResponse go1(XgwVo xgwVo);
    ServerResponse go2(XgwVo xgwVo);

}
