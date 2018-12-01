package com.itzhang.service.impl;

import com.itzhang.dao.RoleDao;
import com.itzhang.domain.Role;
import com.itzhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAllRole() {
        return roleDao.findAllRole();
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public Role findRoleById(Integer id) {
        return roleDao.findRoleById(id);
    }

    @Override
    public void managerRolePermission(Integer roleId, Integer[] ids) {
        //移出原始的权限
        roleDao.removePermissionFromRole(roleId);
        //如果ids有值循环添加中间表数据
        if (ids!=null&&ids.length>0){
            for (Integer pid : ids) {
                roleDao.saveRolePermission(roleId,pid);
            }
        }

    }
}
