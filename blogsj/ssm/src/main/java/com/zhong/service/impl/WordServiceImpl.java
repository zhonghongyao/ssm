package com.zhong.service.impl;

import com.zhong.dao.UserMapper;
import com.zhong.dao.WordMapper;
import com.zhong.entiry.*;
import com.zhong.service.WordService;
import com.zhong.util.MapSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("wordService")
public class WordServiceImpl implements WordService {
    @Autowired
    WordMapper wordMapper;

    @Override
    public List<Word> selectWord() {
        return wordMapper.selectWord();
    }

    @Override
    public List<WordLine> selectWordLine() {
        return wordMapper.selectWordLine();
    }

    @Override
    public List<TimeCount> selectTimeCount() {
        return wordMapper.selectTimeCount();
    }

    public  int insertword(List<Word> list){
       System.out.println(list.size());
        return wordMapper.insertword(list);
    }
    public int insertWordLine(WordLine lines){
        return wordMapper.insertWordLine(lines);
    }
    public int insertTimeCount(List<TimeCount> list){
        return wordMapper.insertTimeCount(list);

    }
    public  void readFile(String filename)throws Exception {
        int countLine=0;//统计行数
        int charCount=0;//统计字符数
        int count1=1,count2=2,count3=3;



        try  (FileReader reader = new FileReader(filename);
              BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ){

            String line;
            int arrCount[] = null;
            Map<String, Integer> map = new HashMap<>();
            int k = 0;
            long start = System.currentTimeMillis();

            while ((line = br.readLine()) != null) {

                countLine++;


                String strSource[] = line.split(" ");

                //函数


                int length = strSource.length;


                //统计字符数（注释--这里不包括逗号，句号，空格）
                for (int i = 0; i < length; i++) {
                    char charStr[] = strSource[i].toCharArray();
                    for (int j = 0; j < charStr.length; j++) {
                        if (charStr[j] != ',' && charStr[j] != '.' && charStr[j] != ' ')
                            charCount++;
                    }
                }

                String strAll[] = line.split(" ");
                for (int i = 0; i < strAll.length; i++) {
                    if (map.size() == 0) {

                        map.put(strAll[i], 1);
                        continue;
                    }
                    int size = map.size();

                    boolean flag = false;
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {

                        if (entry.getKey().equals(strAll[i])) {
                            int temp = entry.getValue();

                            entry.setValue(++temp);
                            flag = true;
                        }
                    }
                    if (flag == false) {

                        map.put(strAll[i], 1);
                    }
                }


            }

            long end = System.currentTimeMillis();
            long countTime = start - end;
            //输出



            Map<String, Integer> mapRe = MapSort.sortMapByValue(map);

            //过滤，。等非单词的字符
            /*for (Map.Entry<String, Integer> entry : mapRe.entrySet()) {

                String str=entry.getKey();
                int value=entry.getValue();
                char c=str.charAt(str.length()-1);
                if(c==','||c=='.'){
                    String strNew=str.substring(0,str.length()-1);
                    mapRe.remove(str);
                    mapRe.put(strNew,value);
                }

            }*/


            System.out.println(mapRe.size());
            //调用mapper
            List<Word> list=new ArrayList<>();
            for (Map.Entry<String, Integer> entry : mapRe.entrySet()) {
                Word word = new Word();
                word.setWord(entry.getKey());
                word.setCount(entry.getValue());
                list.add(word);
            }
            List<TimeCount> list1=new ArrayList<>();
            TimeCount timeCount=new TimeCount();
            timeCount.setTime(countTime);
            timeCount.setType("计时");
            list1.add(timeCount);
            WordLine wordLine=new WordLine();
            wordLine.setCharCount(charCount);
            wordLine.setWordLine(countLine);
            //查询数据库是否已经存在数据
            List<Word> listSelect=wordMapper.selectWord();


            for (int i = 0; i < list.size(); i++) {
                      String str=list.get(i).getWord();
                System.out.println(str);
                for (int j = 0; j <listSelect.size() ; j++) {

                    String str1=listSelect.get(j).getWord();
                    System.out.println(str1);
                    if(str.equals(str1)){
                       list.remove(i);
                       i=i-1;
                       break;
                    }
                }
            }



            if(list.size()>0)
              wordMapper.insertword(list);




            List<WordLine> listSelect1=wordMapper.selectWordLine();

          boolean flag=true;

                for (int j = 0; j <listSelect1.size() ; j++) {
                    if(wordLine.getWordLine()==listSelect1.get(j).getWordLine()){
                       flag=false;

                }
            }
            if(flag==true){
                int j=wordMapper.insertWordLine(wordLine);
            }

            /*    List<TimeCount> timeCountList=wordMapper.selectTimeCount();

            for (int l = 0; l <list1.size() ; l++) {
                for (int m = 0; m < timeCountList.size(); m++) {

                    if(list1.get(l).getType()==timeCountList.get(m).getType()){
                        list1.remove(l);
                        l=l-1;
                        break;
                    }
                }
            }

            if(list1.size()>0)
            wordMapper.insertTimeCount(list1);
*/
            // writeFile(mapRe);
            /*Map<String,Integer> map1= new HashMap<>();
            map1.put("行数",countLine);
            map1.put("字符数",charCount);
            writeFile(map1);*/


        }catch (IOException e) {
            e.printStackTrace();
        }

    }



    /*public static void main(String[] args) {
        WordServiceImpl wordService=new WordServiceImpl();
        List<Word>list=wordService.selectWord();
        if(list.size()>=1)
            System.out.println("有数据");
        else
            System.out.println("无数据");
    }*/


}
