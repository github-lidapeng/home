package com.home.entity;

import java.util.Date;

/**
 * @author 李小末
 */
public class Timu {
    private Integer id;
    private  String name;
    private  String wechat;
    private  String password;
    private  String role;
    private  boolean vip;
    private Date PlayTime;
    private Date createtime;
    private String time;

    @Override
    public String toString() {
        return "Timu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wechat='" + wechat + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", vip=" + vip +
                ", PlayTime=" + PlayTime +
                ", createtime=" + createtime +
                ", time='" + time + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getPlayTime() {
        return PlayTime;
    }

    public void setPlayTime(Date playTime) {
        PlayTime = playTime;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Integer getId() {
        return id;
    }
}
