package com.calendar.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

}

