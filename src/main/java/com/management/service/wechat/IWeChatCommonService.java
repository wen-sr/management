package com.management.service.wechat;

import com.management.common.ServerResponse;
import com.management.pojo.login.Login;
import me.chanjar.weixin.common.error.WxErrorException;

import java.io.IOException;

public interface IWeChatCommonService {
    ServerResponse register(Login login);

    ServerResponse login(Login login);

    Login getUserInfoByIdLike(String id);

    void test() throws Exception;
}
