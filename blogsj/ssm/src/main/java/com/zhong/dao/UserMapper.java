package com.zhong.dao;


import com.zhong.entiry.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface UserMapper {
    User selectUser(@Param("user_name") String user_name);
    List<User> selectId(Map<String,Object>param);
    List<User>  selectList(User user);
    List<User>  selectMap(Map<String,Object> map);

    public int deleteUser(List<String> param);

}
