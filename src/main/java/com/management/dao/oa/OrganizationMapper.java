package com.management.dao.oa;


import com.management.pojo.oa.Organization;
import com.management.vo.oa.OrganizationVo;

import java.util.List;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

    List<OrganizationVo> selectByParentId(Integer id);

    Organization selectByName(String name);

    String selectMaxOrderBy(Integer fooId);
}