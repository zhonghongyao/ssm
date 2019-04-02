package com.zhong.controller;

import com.zhong.entiry.*;
import com.zhong.service.TestDateService;
import com.zhong.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/word")
public class WordController {

    @Autowired
    WordService wordService;

    @RequestMapping(value = "/count" )
    public @ResponseBody
    ResultResponse selectWord()throws  CustomException{
        List<Word> list=wordService.selectWord();
        if(list.size()>=1)
            System.out.println("有数据");
        ResultResponse rs=new ResultResponse(list,0,"");
        return  rs;
    }

    @RequestMapping(value = "/countOther" ,method = RequestMethod.POST)
    public @ResponseBody
    ResultResponse selectWordOther()throws  CustomException{
        String str="at,before,after,since,still,until,upon,on,from,between,by,in,during,for,through,\n" +
                "within,over";
        String strArray[]=str.split(",");
        List<Word> list=wordService.selectWord();
        for (int i = 0; i <list.size() ; i++) {
            String word=list.get(i).getWord();
            if(word!="the"&&word!="an"&&word!="a"){
                boolean flag=true;
                for (int j = 0; j <strArray.length ; j++) {
                    if(word==strArray[j])
                        flag=false;
                }
                if(flag==false){
                    list.remove(i);
                }

            }
        }
        if(list.size()>=1)
            System.out.println("有数据");
        ResultResponse rs=new ResultResponse(list,0,"");
        return  rs;
    }


    @RequestMapping("/wordLine")
    public @ResponseBody
    ResultResponse selectWordLine(){
        List<WordLine> list=wordService.selectWordLine();
        if(list.size()>=1)
            System.out.println("有数据");
        ResultResponse rs=new ResultResponse(list,0,"");
        return  rs;
    }


    @RequestMapping("/timeCount")
    public @ResponseBody
    ResultResponse selectTimeCount(){
        List<TimeCount> list=wordService.selectTimeCount();
        if(list.size()>=1)
            System.out.println("有数据");
        ResultResponse rs=new ResultResponse(list,0,"");
        return  rs;
    }




}
