package com.itzhang.service.impl;

import com.itzhang.dao.PermissionDao;
import com.itzhang.domain.Permission;
import com.itzhang.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAllPermission() {
        return permissionDao.findAllPermission();
    }

    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }
}
