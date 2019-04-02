package com.zhong.controller;


import com.zhong.entiry.User;
import com.zhong.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/showUser")

    public  User selectUser() throws IOException {

        User user=new User();
        user.setUser_name("123");
        user.setPassword("234");
      return user;

    }

    @RequestMapping("/list")
    public String seletList(String user_name,String password,Model model){
        User user=new User();
        user.setUser_name(user_name);
        user.setPassword(password);
        List<User> list=userService.selectList(user);
        model.addAttribute("list",list);
        return "test";

    }

    @RequestMapping("map")
    public String selectMap(String user_name,String password,Model model)
    {
        Map<String,Object> param=new HashMap<>();
        param.put("user_name",user_name);
        param.put("password",password);
        List<User> list=userService.selectMap(param);
        model.addAttribute("list",list);
        return "test";
    }

    @RequestMapping("selectId")
    public String selectId(String name,int pageStart,int pageNum,Model model){
        User param=new User();
        param.setUser_name(name);

        List<User> list=userService.selectId(param,pageStart,pageNum);
        model.addAttribute("list",list);
        return "test";
    }


    @RequestMapping("/delete")
    public String delete(String name,Model model)
    {

        String []param=name.split(",");
        int result=userService.deleteUser(param);
        model.addAttribute("result",result);
        return "delete";
    }
}
