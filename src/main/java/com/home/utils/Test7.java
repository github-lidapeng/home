package com.home.utils;

import org.apache.taglibs.standard.extra.spath.Step;

/**
 * Created by 李小末 on 2020/1/2 11:23
 */
public class Test7 {
    //第一个返回内容是n的个数，第二个返回内容是o的个数
    public static int [] count(String str){
        char[] chars = str.toCharArray();//将字符串变成字符数组
        int[] ints = new int[2];
        for (int x=0; x<chars.length;x++){
            if (chars[x]=='n' || chars[x]=='N'){
                ints[0]++;
            }
            if (chars[x]=='o' || chars[x]=='O'){
                ints[1]++;         }
        }
        return ints;
    }

    public static void main(String[] args) {
        String str="wan an you are school";
        int[] count = Test7.count(str);
        System.out.println("字母为n的个数"+count[0]+",字母为o的个数"+count[1]);
    }
}
  /*  class Person{
        private String name;
        private String addr;
        private char sex;
        private int age;
        public Person(){}
        public Person(String name,String addr){
            this(name,addr,'男',0);
        }
        public Person(String name, String addr,char sex,int age){
            this.name=name;
            this.addr=addr;
            this.sex=sex;
            this.age=age;
        }
        public String getInfo(){
            return "姓名："+this.name+"，住址:"+this.addr+",性别:"+this.sex+",年龄:"+this.age;
        }
    }

    class Student extends Person{
    private double math;
    private double english;

    public Student(){}
    public Student(String name, String addr,char sex,int age,double math,double english){
        super(name,addr,sex,age);
        this.math=math;
        this.english=english;
    }
    public String getInfo2(){
        return super.getInfo()+",数学成绩:"+this.math+",英语成绩:"+english;
    }

    }
*/
