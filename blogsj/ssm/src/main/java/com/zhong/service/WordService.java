package com.zhong.service;

import com.zhong.entiry.TimeCount;
import com.zhong.entiry.User;
import com.zhong.entiry.Word;
import com.zhong.entiry.WordLine;

import java.util.List;

public interface WordService {

    //查询所有的单词
    public List<Word> selectWord();
    public List<WordLine>  selectWordLine();
    public List<TimeCount>selectTimeCount();
    public int insertword(List<Word> list);
    public int insertWordLine(WordLine lines);
    public int insertTimeCount(List<TimeCount> list);
    public  void readFile(String filename)throws Exception;


}
