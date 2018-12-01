package com.itzhang.service;

import com.itzhang.domain.Permission;

import java.util.List;

public interface PermissionService {

    public List<Permission> findAllPermission();

    void savePermission(Permission permission);
}
