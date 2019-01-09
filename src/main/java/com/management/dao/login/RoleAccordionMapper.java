package com.management.dao.login;


import com.management.pojo.login.RoleAccordionKey;

public interface RoleAccordionMapper {
    int deleteByPrimaryKey(RoleAccordionKey key);

    int insert(RoleAccordionKey record);

    int insertSelective(RoleAccordionKey record);

    int deleteByRoleId(Integer id);
}