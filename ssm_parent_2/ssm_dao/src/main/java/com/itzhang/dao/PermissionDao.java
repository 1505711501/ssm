package com.itzhang.dao;

import com.itzhang.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    @Select("select * from sys_permission")
    public List<Permission> findAllPermission();


    @Insert("insert into sys_permission values(com_sequence.nextval,#{permissionName},#{url})")
    void savePermission(Permission permission);

    @Select("select * from sys_permission where id in"+
            "(select permissionid from  sys_role_permission where roleid = #{roleId})")
    public List<Permission> findPermissionsByRoleId(Integer roleId);
}
