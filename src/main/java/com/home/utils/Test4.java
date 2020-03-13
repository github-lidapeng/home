package com.home.utils;

/**
 * Created by 李小末 on 2019/6/4 9:41
 * 线程demo
 */
public class Test4 implements Runnable {
    private  Thread t;
    private String name;
    Test4(String n){
        name=n;
        System.out.println("creating"+name);
    }
    @Override
    public void run() {
        System.out.println("running"+name);
        try {
            for (int i=0;i<4;i++){
                System.out.println("Thread"+name+i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("thread"+name+"interrupted");
        }
        System.out.println("thread"+name+"exiting");
    }
    public void statr(){
        System.out.println("starting"+name);
        if (t == null){
            t=new Thread(this,name);
            t.start();
        }
    }

    public static void main(String[] args) {
        Test4 t1 = new Test4("thread-1");
        t1.statr();
        Test4 t2 = new Test4("thread-2");
        t2.statr();
        
    }
}
