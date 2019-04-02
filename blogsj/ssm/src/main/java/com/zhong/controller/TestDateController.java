package com.zhong.controller;

import com.zhong.entiry.TestDate;
import com.zhong.service.TestDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/testDate")
public class TestDateController {

    @Autowired
    TestDateService testDateService;

    @RequestMapping("/insert")
    public String insertTestDate(int id,String date){
        TestDate testDate=new TestDate();
        testDate.setId(id);



       try{

              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               Date date1=sdf.parse(date);
           testDate.setCreate_time(date1);
           testDateService.insertTestDate(testDate);
       }catch (Exception e){
           e.printStackTrace();
       }

     return "testDate";


    }

    @RequestMapping("/dis")
    public String dis(){
        return "from";
    }




}
