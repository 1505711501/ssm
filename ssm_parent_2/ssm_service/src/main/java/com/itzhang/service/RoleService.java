package com.itzhang.service;

import com.itzhang.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRole();

    void saveRole(Role role);

    Role findRoleById(Integer id);

    void managerRolePermission(Integer roleId, Integer[] ids);
}
