package com.management.service.oa;

import com.management.common.ServerResponse;
import com.management.pojo.oa.Organization;
import com.management.vo.oa.OrganizationVo;

import java.util.List;

public interface IOrganizationService {
    List<OrganizationVo> findTree(Integer id, Integer flag);

    ServerResponse add(Organization organization);

    ServerResponse edit(Organization organization);

    ServerResponse delete(Organization organization);
}
