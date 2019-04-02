package com.zhong.controller;

import com.zhong.entiry.Word;
import com.zhong.entiry.WordLine;
import com.zhong.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("test")
public class TestDate {

    @Autowired
    WordService wordService;
    @RequestMapping("/data")
    public void test(){
        List<Word> list=new ArrayList<>();
        Word word=new Word();
        word.setWord("ccc");
        word.setCount(12);
        list.add(word);
        int i=wordService.insertword(list);

        if(i>0){
            System.out.println("success");
        }
    }
}
