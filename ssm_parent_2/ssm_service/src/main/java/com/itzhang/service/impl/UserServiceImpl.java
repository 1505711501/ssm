package com.itzhang.service.impl;

import com.itzhang.dao.UserDao;
import com.itzhang.domain.Role;
import com.itzhang.domain.SysUser;
import com.itzhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2018/11/26 12:09
 * @Description:
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    BCryptPasswordEncoder pwdEncoder ;
    /*
    *  自定义业务实现类实现框架的方法目的
    *  通过用户名得到User对象用于框架的验证
    */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //通过username获取数据库的真实用户
        SysUser sysUser = userDao.findUserByName(username);
        //创建用于测试的初始化权限集合
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        //真实测试应该通过当前用户得到用户对应的角色集合测试
        List<Role> userRoles = sysUser.getRoles();
        if(userRoles!=null&&userRoles.size()>0){
            //循环用户的角色集合添加所有的角色
            for (Role userRole : userRoles) {
                authorities.add(new SimpleGrantedAuthority(userRole.getRoleName()));
            }
        }

        User user = new User(sysUser.getUsername(),sysUser.getPassword(),sysUser.getStatus()==1?true:false,true,true,true,authorities);

        return user;
    }

    @Override
    public List<SysUser> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public void saveUser(SysUser user) {
        //将页面传递的明文密码变成密文后存储
        String password = user.getPassword();
        user.setPassword(pwdEncoder.encode(password));
        userDao.saveUser(user);
    }

    @Override
    public SysUser findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public void manageUserRole(Integer userId, Integer[] ids) {
        //接受用户id和角色id数组维护关系
        //先通过userid移出原始的角色
        userDao.removeRoleFromUser(userId);
        //用户没有角色直接添加
        if(ids!=null&&ids.length>0){
            for (Integer rid : ids) {
                userDao.saveUserRole(userId,rid);
            }
        }

    }


}
