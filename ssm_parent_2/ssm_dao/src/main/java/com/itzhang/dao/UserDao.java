package com.itzhang.dao;

import com.itzhang.domain.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2018/11/26 12:09
 * @Description:
 */
public interface UserDao {

    @Select("select * from sys_user where username=#{username}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "id",property = "roles",javaType = List.class,
                    many = @Many(select="com.itzhang.dao.RoleDao.findRoleByUserId"))
    })
    SysUser findUserByName(String username);

    @Select("select * from sys_user")
    List<SysUser> findAllUser();

    //通过用户的id得到角色的信息
    @Insert("insert into sys_user values(com_sequence.nextval,#{username}," +
            "#{email},#{password},#{phoneNum},#{status})")
    void saveUser(SysUser user);



    @Select("select * from sys_user where id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "id",property = "roles",javaType = List.class,
                    many = @Many(select="com.itzhang.dao.RoleDao.findRoleByUserId"))
    })
    SysUser findUserById(Integer id);

    @Insert("insert into sys_user_role values(#{userId},#{rid})")
    void saveUserRole(@Param("userId") Integer userId, @Param("rid") Integer rid);

    @Delete("delete from sys_user_role where userid=#{userId}")
    void removeRoleFromUser(Integer userId);
}
