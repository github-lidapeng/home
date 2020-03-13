package com.home.utils;


import java.net.SocketOption;

/**
 * 枚举的小demo
 * Created by 李小末 on 2019/5/25 14:02
 */
public class TestEnum {
    /**
     * 普通枚举(颜色)
     */
    public enum ColorEnum{
        red,green,yellow,blue;
    }

    /**
     * 四季
     */
    public enum  SeasonEnum{
        spring,summer,autumn,winter;
        private final static String position="test";

        public static SeasonEnum getSeason(){
            if ("test".equals(position)) {
                return spring;
            }else {
                return winter;
            }
        }
    }

    /**
     * 性别
     * 实现带有构造器的枚举
     *   通过括号赋值,而且必须带有一个参构造器和一个属性跟方法，否则编译出错
     *   赋值必须都赋值或都不赋值，不能一部分赋值一部分不赋值；如果不赋值则不能写构造器，赋值编译也出错
     */
    public enum Gender{
        Man("Man"),WOMEN("WOMEN");

        private final String value;

        Gender(String value){
            this.value=value;
        }
        public String getValue(){
            return value;
        }
    }

    /**
     * 订单状态
     */
    public enum OrderState{
        /** 已取消 **/
        CANCEL{
            @Override
            public String getName(){return "已取消";}},
        /** 待审核 **/
        WAITCONFIRM {
            @Override
            public String getName(){return "待审核";}},
        /** 等待付款 **/
        WAITPAUMENT {
            @Override
            public String getName(){return "等待付款";}},
        /** 正在配货 **/
        ADMEASUREPRODUCT {
            @Override
            public String getName(){return "正在配货";}},
        /***等待发货 */
        WAITDELIVER {
            @Override
            public String getName(){return "等待发货";}},
        /** 已发货 **/
        DELIVERED {
            @Override
            public String getName(){return "已发货";}},
        /** 已收货 **/
        RECEIVED {
            @Override
            public String getName(){return "已收货";}};

        public abstract String getName();
    }

    public static void main(String[] args) {
        ColorEnum colorEnum = ColorEnum.blue;
        switch (colorEnum){
            case red:
                System.out.println("color is red");
                break;
            case green:
                System.out.println("color is green");
                break;
            case yellow:
                System.out.println("color is yellow");
                break;
            case blue:
                System.out.println("color is blue");
                break;
        }


        /**遍历枚举                                          **/
        System.err.println("遍历colorEnum枚举中的值");
        for (ColorEnum color : ColorEnum.values()){
            System.err.println(color);
        }

        /** 获取枚举的个数 **/
        System.out.println("ColorEnum枚举中的值有"+ColorEnum.values().length+"个");


        /**枚举默认实现了java.lang.Conmparable接口**/
        System.out.println(ColorEnum.red.compareTo(ColorEnum.green));

        System.out.println("-------------------------季节-------------------------------------");
        /** 季节 **/
        System.out.println("季节为"+SeasonEnum.getSeason());

        System.out.println("------------------------性别--------------------------------------");
        for (Gender gender : Gender.values()){
            System.out.println(gender.value);
        }
        System.out.println("------------------------------订单----------------------------------------");
        for (OrderState order : OrderState.values()){
            System.out.println(order.getName());
        }

        System.out.println("----------------------------------------------");
        OrderState s = OrderState.ADMEASUREPRODUCT;
        System.out.println(s.getName());
    }
}
