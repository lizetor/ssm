package com.tornado.controller;

import com.tornado.domain.User;
import com.tornado.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("user/")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("find.html")
    public String find(Integer id, Model model) {

        User user = userService.findUserById(id);

        model.addAttribute("user", user);

        return "user/show";
    }

    @GetMapping("multiView")
    public User multiView() {
        User user = userService.findUserById(1);
        user.setUsername("test");
        user.setPassword("password");
        return user;
    }

}
