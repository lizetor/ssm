package com.tornado.controller;

import com.tornado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("login.html")
    public String login(RedirectAttributes attr) {
        attr.addFlashAttribute("a", "a");
        attr.addAttribute("b", "b");
        return "redirect:/user/list.html";
    }

}
