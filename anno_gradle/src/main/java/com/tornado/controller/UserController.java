package com.tornado.controller;

import com.tornado.domain.User;
import com.tornado.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user/")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private HttpSession session;

    @Resource
    private HttpServletRequest request;

    @GetMapping("find.html")
    public String find(Integer id, Model model) {

        User user = userService.findUserById(id);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(session.getAttribute("s_key"));
        stringBuilder.append(":");
        stringBuilder.append(request.getSession().getAttribute("s_value"));

        model.addAttribute("kv", stringBuilder);
        model.addAttribute("user", user);

        return "user/show";
    }

    @GetMapping("multiView")
    public User multiView() {
        return userService.findUserById(1);
    }

    @GetMapping("list.html")
    public String list(String a, String b, Model model) {
        model.addAttribute("user_a", a);
        model.addAttribute("user_b", b);
        return "user/show";
    }

}
