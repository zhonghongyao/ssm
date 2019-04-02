package com.zhong.service;


import com.zhong.entiry.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public User selectUser(String user_name);
    public List<User> selectId(User user,int pageStart,int pageNum);
    public List<User> selectList(User user);
    public List<User> selectMap(Map<String,Object> map);


    public int deleteUser(String[] list);
}
