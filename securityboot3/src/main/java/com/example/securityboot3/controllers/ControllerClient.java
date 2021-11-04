package com.example.securityboot3.controllers;

import com.example.securityboot3.model.User;
import com.example.securityboot3.service.RoleService;
import com.example.securityboot3.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerClient {
    private UserService userService;
    private RoleService roleService;

    public ControllerClient(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/client")
    public String client (@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "/client/client";
    }
}
