package com.itzhang.dao;

import com.itzhang.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

    @Select("select * from sys_role")
    List<Role> findAllRole();

    @Insert("insert into sys_role values (com_sequence.nextval,#{roleName},#{roleDesc})")
    void saveRole(Role role);

    @Select("select * from sys_role where id in " +
            "(select roleid from sys_user_role where userid=#{userId})")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "id",property = "permissions",javaType = List.class, many = @Many(select = "com.itzhang.dao.PermissionDao.findPermissionsByRoleId")
            )
    })
    public List<Role> findRoleByUserId(Integer userId);

    @Select("select * from sys_role where id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "id",property = "permissions",javaType = List.class, many = @Many(select = "com.itzhang.dao.PermissionDao.findPermissionsByRoleId")
            )
    })
    Role findRoleById(Integer id);


    @Delete("delete from sys_role_permission where roleid=#{roleId} ")
    void removePermissionFromRole(Integer roleId);

    @Insert("insert into sys_role_permission values(#{pid},#{roleId})")
    void saveRolePermission(@Param("roleId") Integer roleId, @Param("pid") Integer pid);
}
