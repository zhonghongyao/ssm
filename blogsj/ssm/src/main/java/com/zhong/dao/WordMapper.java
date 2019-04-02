package com.zhong.dao;

import com.zhong.entiry.TimeCount;
import com.zhong.entiry.User;
import com.zhong.entiry.Word;
import com.zhong.entiry.WordLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordMapper {

    List<Word> selectWord();
    List<WordLine> selectWordLine();
    List<TimeCount> selectTimeCount();
    int insertword(List<Word> list);
    int insertWordLine(WordLine  lines);
    int insertTimeCount(List<TimeCount> list);

}
