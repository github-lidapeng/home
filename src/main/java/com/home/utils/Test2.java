package com.home.utils;


import com.sun.org.apache.bcel.internal.classfile.Utility;

import java.util.*;

import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;


/**
 * Created by 李小末 on 2019/5/30 13:54
 * 集合
 */
public class Test2 {
    public static void main(String[] args) {
       /* ArrayList<String> list = new ArrayList<String>();
        list.add("lisi");
        list.add("zhangsan");
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());

        }*/
       /* Map<String, Object> map = new HashMap<>();
        map.put("1","lixiaomo");
        map.put("2","wutian");*/
       /* for (String s : map.keySet()){
            System.out.println(s+""+map.get(s));
        }*/
       /* Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, Object> entry = it.next();
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }*/

        /*for (Map.Entry<String, Object> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }*/
        Integer[] array={1,3,5,7,9};
        Double[] doubles={1.2,1.3,4.3};
        for (int i=0;i<array.length;i++){
        System.out.println("整数"+array[i]);}
        System.out.println("----");
        printArray(array);
        System.out.println(0xA |3);
        System.out.println(0xA&3);
        System.err.println(0+1+3*4+4%3);
        System.out.println(10%3);
    }
}
