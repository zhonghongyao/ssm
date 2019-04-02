package com.zhong.service.impl;

import com.gargoylesoftware.htmlunit.Page;
import com.zhong.dao.UserMapper;
import com.zhong.entiry.User;
import com.zhong.entiry.page;
import com.zhong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUser(String user_name) {
        return userMapper.selectUser(user_name);
    }

    @Override
    public List<User> selectId(User user, int pageStart, int pageNum) {
        Map<String,Object> param=new HashMap<>();
        page page=new page();
        page.setPageNum(pageNum);
        page.setPageStart(pageStart);


        param.put("user",user);
        param.put("page",page);
        return userMapper.selectId(param);
    }

    @Override
    public List<User> selectList(User user) {
        return userMapper.selectList(user);
    }

    @Override
    public List<User> selectMap(Map<String, Object> map) {
        return userMapper.selectMap(map);
    }

    @Override
    public int deleteUser(String[] list) {
        for (int i = 0; i <list.length ; i++) {
            System.out.println(list[i]);
        }
        List<String> aa=new ArrayList<>();
        aa.add("1");
        aa.add("2");
        aa.add("3");
        return userMapper.deleteUser(aa);
    }


}
