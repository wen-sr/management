package com.management.service.login;

import com.management.common.ServerResponse;
import com.management.pojo.login.Authority;
import com.management.pojo.login.Role;

import java.util.List;

public interface IRoleService {
    ServerResponse findAll(Role role);

    List<Authority> getAuth(Integer id);

    ServerResponse addRole(Role role);

    ServerResponse editRole(Role role);

    ServerResponse comfirmAuth(Integer roleId, String[] ids);

    ServerResponse deleteRole(Role role);
}
