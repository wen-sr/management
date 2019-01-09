package com.management.service.wechat;

import com.management.pojo.wechat.UserInfo;

public interface IUserInfoService {
    UserInfo findByOpenId(String openId);

}
