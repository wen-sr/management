package com.management.service.liku.impl;

import com.management.common.ServerResponse;
import com.management.dao.liku.BankShuttleMapper;
import com.management.service.liku.ILikuService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.liku.ErrorMessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/8/19 14:16
 * Modified By：
 */
@Service
public class LikuServiceImpl implements ILikuService {

    @Autowired
    BankShuttleMapper bankShuttleMapper;

    @Override
    public ServerResponse getErrorMsg() {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_LIKU);
        List<ErrorMessageVo> errorMessageVoList = bankShuttleMapper.getErrorMsg();
        return ServerResponse.createBySuccess(errorMessageVoList);
    }
}
