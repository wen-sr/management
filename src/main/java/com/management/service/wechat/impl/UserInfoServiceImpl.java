package com.management.service.wechat.impl;

import com.management.dao.wechat.UserInfoMapper;
import com.management.pojo.wechat.UserInfo;
import com.management.service.wechat.IUserInfoService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserInfoServiceImpl implements IUserInfoService {


    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findByOpenId(String openId) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        return userInfoMapper.selectByOpenId(openId);
    }
}
