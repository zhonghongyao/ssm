package com.zhong.entiry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDate implements Serializable {
    private int id;
    private Date create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }


    public static void main(String[] args) {

        List<Word> list=new ArrayList<>();
        List<Word> list1=new ArrayList<>();
        Word word=new Word();
        word.setWord("123");
        list.add(word);
        Word word4=new Word();
        word4.setWord("1234");
        list.add(word4);


        for (int i = 0; i <list.size() ; i++) {
            for (int j = 0; j <4 ; j++) {
                list.remove(i);
                i=i-1;
                break;
            }
            System.out.println("123");

        }
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).getWord());
        }


    }
}
