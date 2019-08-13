package com.controller;

import com.myAnnotation.ConnectSuccess;
import com.service.GetUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ControllerTest
 * @Description
 * @Author acer
 * @Date 2019/7/14 12:42
 * @Version 1.0
 **/
@Controller
@RequestMapping("/login")
public class ControllerTest {

    @Autowired
    GetUsersService getUsersService;

    @ConnectSuccess(flag = true)
    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @ResponseBody
    @RequestMapping("/doLogin")
    public String doLogin(String userId, String password) {
        getUsersService.getCount();
        return "--" + userId + ":" + password + "--";
    }
}
