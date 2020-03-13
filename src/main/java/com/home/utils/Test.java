package com.home.utils;


import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
/**
 * Created by 李小末 on 2019/5/27 14:13
 * 正则表达式demo
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
    //判断一个QQ是否合法 即5-10位数,不能是0开头
       // checkQQ("123456");
        //判断一个邮箱格式是否正确
        qqYx("changyu@qq.com");
    }

    private static void qqYx(String s) {
        String yx="\\w+@\\w+(\\.+[a-zA-Z]+)+";
        System.out.println(s.matches(yx)? "正确的格式" : "错误的格式");
    }
    //正则
   /* private static void checkQQ(String s) {
        //第一个[]为第一个数字的取值范围（合法），第二个[]为第一个数字的取值范围（不合法）,{}为qq的个数，从坐标为0也就是第一个数算起
        String qq="[1-9][0-9]{4,9}";
        System.out.println(s.matches(qq) ? "合法qq" : "非法qq");
    }*/
/*---------------------------------------------------------------------------------------------------------------------------------------*/
   /* private static void checkQQ(String qq) {
        int len = qq.length();
        if (len >= 5 && len <= 10){
            if (!qq.startsWith("0")){
                long q = Long.parseLong(qq);
                System.out.println(q);
            }else {
                System.err.println("qq开头不能为0");
            }
        }else {
            System.err.println("非法输入");
        }
    }*/
}
