package com.management.service.wechat;

import com.management.pojo.wechat.UserInfo;

import java.util.List;

public interface IUserInfoService {
    UserInfo findByOpenId(String openId);

    List<UserInfo> findByroleId(int i);
}
