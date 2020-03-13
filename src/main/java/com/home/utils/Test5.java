package com.home.utils;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 李小末 on 2019/6/5 13:47
 * 分割字符串
 */
public class Test5 {
    public static void main(String[] args) throws IOException {
      /*  String str="Welcome-to-chine";
        String[] temp;
        String d="-";//指定分割字符
        temp = str.split(d);
        //普通fot
        for (int i=0; i<str.length();i++){
            System.err.println("---");
        }
        String s = new StringBuffer(str).reverse().toString();
        System.out.println(s);
        System.err.println(str.toUpperCase());
        //增强for
     *//*   String s="www.baidu.com";
        String f="\\.";
        String[] split = s.split(f);
        for (String i : split){
            System.out.println(i);
        }*//*
     Integer[] arr={1,4,6,8,3,2,5};
        int min = Collections.min(Arrays.asList(arr));
        Integer max = Collections.max(Arrays.asList(arr));
        System.out.println(min);
        System.out.println(max);
    }*/

        /*----------------------------------------------*/
        Integer[] a = {1, 3, 5};
        Integer[] b = {2, 4, 6};
        ArrayList list = new ArrayList(Arrays.asList(a));
       list.addAll(Arrays.asList(b));
        Object[] o = list.toArray();
        System.out.println(Arrays.toString(o));
        long millis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(millis))));
        System.out.println(sd);


        File fileToChange = new File("D:/myjavafile.txt");
        fileToChange.createNewFile();
        Date filetime = new Date(fileToChange.lastModified());
        System.out.println(filetime.toString());
        System.out.println(fileToChange.setLastModified(System.currentTimeMillis()));
        filetime = new Date(fileToChange.lastModified());
        System.out.println(filetime.toString());
        File file = new File("D:/demo.txt");
        file.createNewFile();

    }

}

