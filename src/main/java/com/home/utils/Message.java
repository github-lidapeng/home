package com.home.utils;

import java.util.HashMap;
import java.util.Map;

public class Message {

    /**
     * 报文信息
     * @param state
     * @param msg
     * @param data
     * @return
     */
    public static Map<String,Object> getMessage(int state,String msg,Object data){
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("state",state);
            map.put("msg",msg);
            map.put("data",data);
            return map;
    }

    /**
     * 提示信息
     * @param state
     * @param msg
     * @return
     */
    public static Map<String,Object> getState(int state,String msg) {
             Map<String,Object> map=new HashMap<String, Object>();
             map.put("state",state);
             map.put("msg",msg);
             return map;

    }


}
