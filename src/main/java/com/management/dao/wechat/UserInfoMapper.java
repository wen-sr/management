package com.management.dao.wechat;

import com.management.pojo.wechat.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo selectByOpenId(String openId);

    List<UserInfo> selectByLoginIds(@Param(value = "roleIds") List<String> roleIds);

    UserInfo selectUserByName(String name);

    UserInfo selectByLoginId(String login_id);

    List<UserInfo> findByroleId(int i);

    List<UserInfo> findAll();
}