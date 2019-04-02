/*
package com.zhong.controller;

import com.zhong.util.MapSort;
import org.apache.bcel.generic.NEW;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception{
       readFile();
       */
/* String str[]={"123,234","345.bnm","456"};

        str=contect(str);

        System.out.println(Arrays.toString(str));*//*


    }
    public static void readFile()throws Exception {
        int countLine=0;//统计行数
        int charCount=0;//统计字符数
        int count1=1,count2=2,count3=3;


        String pathname ="word.txt";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
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

                break;
            }

            long end = System.currentTimeMillis();
            long countTime = start - end;
            //输出



            Map<String, Integer> mapRe = MapSort.sortMapByValue(map);

            //过滤，。等非单词的字符
            for (Map.Entry<String, Integer> entry : mapRe.entrySet()) {

               String str=entry.getKey();
               int value=entry.getValue();
                char c=str.charAt(str.length()-1);
                if(c==','||c=='.'){
                       String strNew=str.substring(0,str.length()-1);
                        mapRe.remove(str);
                        mapRe.put(strNew,value);
                }

            }





            writeFile(mapRe);
            */
/*Map<String,Integer> map1= new HashMap<>();
            map1.put("行数",countLine);
            map1.put("字符数",charCount);
            writeFile(map1);*//*



        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    */
/**
     * 写入TXT文件
     *//*

    public static void writeFile(Map<String,Integer> map) {
        try {
            File writeName = new File("output.txt");
            writeName.createNewFile();
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {

                    out.write(entry.getKey()+"数量："+entry.getValue()+"\r\n");

                }
                out.flush();



            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   */
/* public  static String[] contect(String strSource[]){
        String suffixStr[]=new String[0];
        int count=0;
        //判断单词中有，或者。
        for (int i = 0; i <strSource.length; i++) {
            char cArry[]=strSource[i].toCharArray();
            for (int j = 0; j <cArry.length ; j++) {
                if(j!=cArry.length-1){
                    String temP=cArry.toString();

                    if(cArry[j]==',')
                    {
                       String [] tempSuffixStr=temP.split(",");
                        suffixStr= returnString(suffixStr,tempSuffixStr);
                    }
                    else if(cArry[j]=='.'){
                       String [] tempSuffixStr=temP.split(".");
                        suffixStr= returnString(suffixStr,tempSuffixStr);
                    }





                   System.out.println(Arrays.toString(suffixStr));





                }
            }

        }

         strSource=returnString(strSource,suffixStr);



            return strSource;

    }

    public static String[]  returnString(String str1[],String str2[]){
        String[] newStr = new String[str1.length+str2.length];
        //newStr = str1;数组是引用类型
        for(int x=0;x<str1.length;x++){
            newStr[x] = str1[x];
        }
        for(int y=0;y<str2.length;y++){
            newStr[str1.length+y]=str2[y];
        }
        return newStr;
    }

*//*


}
*/
