package com.management.dao.login;

import com.management.pojo.login.RoleLoginKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleLoginMapper {
    int deleteByPrimaryKey(RoleLoginKey key);

    int insert(RoleLoginKey record);

    int insertSelective(RoleLoginKey record);

    List<Integer> selectByLoginId(@Param(value = "id") String id);

    int deleteByLoginId(String id);

}