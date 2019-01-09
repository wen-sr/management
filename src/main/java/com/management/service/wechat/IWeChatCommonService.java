package com.management.service.wechat;

import com.management.common.ServerResponse;
import com.management.pojo.login.Login;

public interface IWeChatCommonService {
    ServerResponse register(Login login);

    ServerResponse login(Login login);

    Login getUserInfoByIdLike(String id);
}
