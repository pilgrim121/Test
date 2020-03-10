package com.example.demo.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class LoginController {

    @GetMapping
    public String loginPage(){
        return "admin/login";
    }
    //访问admin即可跳进login页面
}
