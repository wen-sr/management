package com.management.dao.login;


import com.management.pojo.login.AuthorityMid;
import com.management.pojo.login.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> findAll(Role role);

    List<AuthorityMid> selectById(Integer id);

    Role selectByName(String name);

    int selectMaxOrderBy();

}