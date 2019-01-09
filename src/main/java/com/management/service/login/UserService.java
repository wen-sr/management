package com.management.service.login;

import com.management.common.ServerResponse;
import com.management.pojo.login.Authority;
import com.management.pojo.login.Login;
import com.management.vo.login.Menu;
import com.management.vo.login.Nav;

import java.util.List;

/**
 * Description:
 * User: wen-sr
 * Date: 2017-09-03  12:56
 */
public interface UserService {
    ServerResponse<List> login(Login user);

    List<Integer> getRole(String id);

    List<Menu> getAccordionByRoleId(int roleId, String loginSystemFlag);

    List<Nav> getAccordionByLoginId(String id, String loginSystemFlage);

    Login getUserInfoById(String id);

    ServerResponse findAll(Login user, Integer pageSize, Integer pageNum);

    ServerResponse addUser(Login user);

    List<Authority> getAllRole(String s);

    ServerResponse confirmRole(String id, String[] ids);

    ServerResponse editUser(Login user);

    ServerResponse deleteUser(Login user);

    ServerResponse modifyPwd(String id, String oldPwd, String newPwd);
}
