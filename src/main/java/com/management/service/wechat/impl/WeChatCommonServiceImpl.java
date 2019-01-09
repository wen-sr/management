package com.management.service.wechat.impl;

import com.management.common.ServerResponse;
import com.management.dao.login.LoginMapper;
import com.management.dao.prd1.XsogroupMapper;
import com.management.pojo.login.Login;
import com.management.util.DataSourceContextHolder;
import com.management.util.MD5Util;
import com.management.dao.wechat.UserInfoMapper;
import com.management.service.wechat.IWeChatCommonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeChatCommonServiceImpl implements IWeChatCommonService {

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    XsogroupMapper xsogroupMapper;


    @Override
    public ServerResponse register(Login login) {

        String id = login.getId();
        String pwd = login.getPwd();
        login.setBk2(MD5Util.MD5EncodeUtf8(pwd));
        String name = idIsExist(id);

        if(isRegistered(id)){
            return ServerResponse.createByErrorMessage("您输入的客户代码已注册！");
        }

        if(StringUtils.isBlank(name)){
            return ServerResponse.createByErrorMessage("您输入的客户代码不存在！");
        }
        login.setName(name);
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        int i = loginMapper.insertSelective(login);
        if(i > 0){
            return ServerResponse.createBySuccess(login);
        }
        return ServerResponse.createByErrorMessage("数据库操作失败，请联系管理员");
    }

    @Override
    public ServerResponse login(Login login) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        login = loginMapper.selectUserByIdAndPwd(login.getId(), MD5Util.MD5EncodeUtf8(login.getPwd()));
        if(login != null){
            return ServerResponse.createBySuccess(login);
        }
        return ServerResponse.createByErrorMessage("用户名或密码错误");
    }

    @Override
    public Login getUserInfoByIdLike(String id) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
       Login login = loginMapper.selectByPrimaryKey(id);
        if(login != null){
            return login;
        }
        return null;
    }


    String idIsExist(String id){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        String name = xsogroupMapper.selectStorerById(id);
        if(StringUtils.isNotBlank(name)){
            return name;
        }
        return null;
    }

    boolean isRegistered (String id){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        Login login = loginMapper.selectByPrimaryKey(id);
        if(login != null){
            return true;
        }
        return false;
    }
}
