package com.itzhang.controller;


import com.itzhang.domain.Permission;
import com.itzhang.domain.Role;
import com.itzhang.service.PermissionService;
import com.itzhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/role")
/*
 * 1.JSR250注解  @RolesAllowed("ROLE_zhang")
 * 2.secure注解的权限拦截 @Secured("ROLE_zhang")
 * 2.表达式注解验证  @PreAuthorize("hasRole('ROLE_zhang')")
 * */
@PreAuthorize("hasRole('ROLE_zhang')")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAllRole")
    public String findAllRole(Model model) {

        List<Role> roleList = roleService.findAllRole();

        model.addAttribute("roleList", roleList);

        return "role/roleList";
    }

    //添加角色的跳转
    @RequestMapping("/addRoleUI")
    public String addRoleUI() {

        return "role/roleAdd";
    }

    //保存角色到数据库
    @RequestMapping("/addRole")
    public String addRole(Role role) {
        roleService.saveRole(role);

        return "redirect:/role/findAllRole";
    }

    @RequestMapping("/managerRolePermissionUI")
    public String managerRolePermissionUI(Integer id, Model model) {
        //得到角色对象
        Role role = roleService.findRoleById(id);
        model.addAttribute("role", role);
        //得到角色的权限
        List<Permission> rolePermissions = role.getPermissions();
        if (rolePermissions != null && rolePermissions.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Permission rolePermission : rolePermissions) {
                sb.append(rolePermission.getPermissionName() + "-");
            }
            model.addAttribute("pStr", sb.toString());
        }

        //所有的权限集合
        List<Permission> permissions = permissionService.findAllPermission();
        model.addAttribute("permissions", permissions);

        return "role/managerRolePermission";

    }


    /**+
     * 功能描述：给句传递的角色id和权限id数值维护中间表的数据
     * @param roleId
     * @param ids
     * @return
     */
    @RequestMapping("/managerRolePermission")
    public String managerRolePermission(Integer roleId,Integer[] ids ){
        roleService.managerRolePermission(roleId,ids);

        return "redirect:/role/findAllRole";
    }

}
