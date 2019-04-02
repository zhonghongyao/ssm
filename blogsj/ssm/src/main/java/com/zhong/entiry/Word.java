package com.zhong.entiry;

import java.io.Serializable;

public class Word implements Serializable {

    private String word;//单词
    private int type;//类型
    private int count;//数量



    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
