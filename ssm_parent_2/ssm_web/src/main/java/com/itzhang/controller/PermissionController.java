package com.itzhang.controller;


import com.itzhang.domain.Permission;
import com.itzhang.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

   @RequestMapping("/findAllPermission")
    public String findAllPermission(Model model){
       List<Permission> permissions = permissionService.findAllPermission();
       model.addAttribute("permissions",permissions);

       return "permission/permissionList";
   }

   @RequestMapping("/addPermissionUI")
    public String addPermissionUI(){

       return "permission/permissionAdd";
   }

   @RequestMapping("/addPermission")
    public String addPermission(Permission permission){
       permissionService.savePermission(permission);

       return "redirect:/permission/findAllPermission";
   }

}
