package com.home.utils;


import java.io.*;

/**
 * Created by 李小末 on 2019/6/6 14:46
 */

public class Test6 {
    public static void main(String[] args) throws IOException {
        /*-------break---------*/
        int[] arr={11,32,2,1,3,43,23,15};
        int no=3;
        int i=0;
        boolean b=false;
        for (;i<arr.length;i++){
            if (arr[i] == no){
                b=true;
                break;
            }
        }
        if (b){
            System.out.println(no+"数组的下标为"+i);
        }

        System.err.println("---------------------------------------------");


        for (int a=1;a<=9;a++){
            for (int c=1;c<=a;c++){
                System.out.print(a+"*"+c+"="+a*c+"\t");
            }
            System.out.println();
        }

        System.err.println("-------------------------------------------------");
        for (int m = 1; m <= 4; m++) {
            //打印空格
            for (int n = 0; n <= m; n++) {
                System.out.print(" ");
            }
            //打印*
            for (int x = 1; x <= 7 -2 * (m - 1); x++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.err.println("-------------------------------------------------------------");
        BufferedWriter out = new BufferedWriter(new FileWriter("runoob.txt"));
        out.write("你好，再见");
        out.append("dasd");
        out.newLine();
        out.write("撒拉嘿哟");
        out.flush();
        out.close();
        System.out.println("文件创建成功");
        BufferedReader in = new BufferedReader(new FileReader("runoob.txt"));
        StringBuffer sb;
        while (in.ready()){
            sb=(new StringBuffer(in.readLine()));
            System.out.println(sb);
        }
        in.close();

    }

}
