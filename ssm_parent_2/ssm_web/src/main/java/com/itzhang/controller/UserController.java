package com.itzhang.controller;


import com.itzhang.domain.Role;
import com.itzhang.domain.SysUser;
import com.itzhang.service.RoleService;
import com.itzhang.service.UserService;
import com.itzhang.util.CustomException;
import com.sun.tools.internal.ws.processor.generator.CustomExceptionGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAllUser")
    public String findAllUser(Model model) throws Exception{

        try {
            int i = 1 / 0;

            List<SysUser> userList = userService.findAllUser();

            model.addAttribute("userList", userList);
        }catch (Exception e){
            throw new CustomException("gg","查询所有报错"+e.getMessage()+"传递参数：==");
        }


        return "user/userList";

    }

    @RequestMapping("/addUserUI")
    public String addUserUI(){

        return "user/userAdd";
    }


    /**
     * 接受页面输入的信息保存到数据库
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(SysUser user){

        userService.saveUser(user);

        return "redirect:/user/findAllUser";
    }

    @RequestMapping("/managerUserRoleUI")
    public String mangerUserRole(Integer id,Model model){

        //先通过用户id得到用户的信息
        SysUser user = userService.findUserById(id);
        //当前用户对应的角色集合
        List<Role> userRoles = user.getRoles();
        //将用户的所有角色集合遍历组装成一个字符串用于页面判断使用
        if(null!=userRoles&&userRoles.size()>0){
            StringBuilder sb =  new StringBuilder();
            for (Role userRole : userRoles) {
                sb.append(userRole.getRoleName()+",");
            }
            model.addAttribute("roleStr",sb.toString());
        }
        //数据的所有角色
        List<Role> roles = roleService.findAllRole();

        model.addAttribute("user",user);
        model.addAttribute("roles",roles);

        return "user/managerUserRole";
    }

    /**
     * 功能描述:通过传递的用户id和角色id数组维护关系
     */
    @RequestMapping("/managerUserRole")
    public  String managerUserRole(Integer userId,Integer[] ids){

        userService.manageUserRole(userId,ids);

        return "redirect:/user/findAllUser";
    }

    @RequestMapping("/userDetail")
    public String userDetail(Integer id,Model model){
        //根据用户id得到用户的数据
        //保证同时得到用户的角色和角色下的权限
        SysUser user = userService.findUserById(id);

        model.addAttribute("user",user);

        return "user/userDetail";
    }


}
