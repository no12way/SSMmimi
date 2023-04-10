package com.controller;

import com.pojo.Admin;
import com.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    //视图层会调用业务层,就像业务层一定会调用dao层一样
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){
        //我们调用service层的方法,返回一个admin实体类
        Admin admin = adminService.login(name, pwd);
        //登录成功
        if(admin != null){
            request.setAttribute("admin",admin);
            return "main";
        }
        //登录失败
        else {
            request.setAttribute("errmsg","用户名或密码不正确");
            return "login";
        }
    }
}
