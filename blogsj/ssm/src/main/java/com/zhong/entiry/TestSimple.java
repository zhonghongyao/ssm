package com.zhong.entiry;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 测试用例
 *
 * */
public class TestSimple {
    public static void main(String[] args) {

        String user="";//用户
        String ticket="1";//票据
        if(user==null||user==""){
            System.out.println("用户名为空");
        }else if(user!=null&&ticket==null){
            System.out.println("用户名不为空，但是票据为空");
        }else if((user!=null&&ticket!="")&&ticket!=null&&ticket!=""){
            System.out.println("用户名不为空，票据不为空");
        }

        JSONObject jsonObject=JSON.parseObject("{sd:123}");
        System.out.println(jsonObject.toJSONString());




    }
}
