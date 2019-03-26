package com.management.service.wechat.impl;

import com.management.common.ServerResponse;
import com.management.dao.login.LoginMapper;
import com.management.dao.prd1.XsogroupMapper;
import com.management.dao.wechat.UserInfoMapper;
import com.management.exception.MyException;
import com.management.pojo.login.Login;
import com.management.service.wechat.IWeChatCommonService;
import com.management.util.DataSourceContextHolder;
import com.management.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        String name = idIsExist(id, login.getBk5());

        if(StringUtils.isBlank(name)){
            throw new MyException(-1, "您输入的客户代码不存在！");
        }

        if(isRegistered(id, login.getBk5())){
            throw new MyException(-1, "您输入的客户代码已注册！");
        }

        login.setName(name);
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        int i = loginMapper.insertSelective(login);
        if(i > 0){
            return ServerResponse.createBySuccess("注册成功", login);
        }
        return ServerResponse.createByErrorMessage("数据库操作失败，请联系管理员");
    }

    @Override
    public ServerResponse login(Login login) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        List<Login> loginList = loginMapper.findAll(login);
        if(loginList != null && loginList.size() == 1){
            return ServerResponse.createBySuccess(loginList.get(0));
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


    String idIsExist(String id, String businessType){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        String name = "";
        if("1".equals(businessType)){
            name = xsogroupMapper.selectStorerById(id);
        }else if("2".equals(businessType)){
            name = xsogroupMapper.selectJiaoCaiStorerById(id);
        }
        return name;
    }

    boolean isRegistered (String id, String businessType){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        Login login = new Login();
        login.setId(id);
        login.setBk5(businessType);
        List<Login> loginList = loginMapper.findAll(new Login(id, businessType));
        if(loginList != null && loginList.size() > 0){
            return true;
        }
        return false;
    }
}
