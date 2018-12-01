package com.itzhang.service;

import com.itzhang.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2018/11/26 12:09
 * @Description:
 */
public interface UserService extends UserDetailsService {
    List<SysUser> findAllUser();


    void saveUser(SysUser user);


    SysUser findUserById(Integer id);

    void manageUserRole(Integer userId, Integer[] ids);
}
