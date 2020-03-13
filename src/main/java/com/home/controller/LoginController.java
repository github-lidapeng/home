package com.home.controller;
import com.home.entity.Timu;
import com.home.service.TimuService;
import com.home.utils.MD5Utils;
import com.home.utils.Message;
import javafx.beans.value.ObservableValueBase;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.util.Password;

import javax.management.relation.Role;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
/**
 *
 */
public class LoginController {

@Autowired
private TimuService service;

@RequestMapping(value = "/notLogin", method = RequestMethod.GET)
@ResponseBody
public Object notLogin(){
    return Message.getMessage(302,"您尚未登录",null);
}
@RequestMapping(value = "/notRole", method = RequestMethod.GET)
@ResponseBody
public Object notRole(){
    return Message.getMessage(403,"您没用权限！",null);
}
@RequestMapping(value = "/logout", method = RequestMethod.GET)
@ResponseBody
public Object logout(){
    Subject subject = SecurityUtils.getSubject();
    subject.logout();
    return Message.getMessage(0,"成功注销",null);
}
    /**
     *  登录
     * @param name
     * @param password
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("login")
    public  Object login(String name, String password) throws Exception{
        if(name !=null && password !=null){
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(name,password);
            subject.login(token);
            String role = service.verifyTimuName(name).getRole();
           // service.updateTimu();
            if ("user".equals(role)){
                return  Message.getMessage(0,"登录成功",name);
            }
            if ("admin".equals(role)){
                return Message.getMessage(0,"登录成功",name);
            }
            if("vip".equals(role)){
                return Message.getMessage(0,"登录成功",name);
            }
        }
        return Message.getMessage(403,"权限错误", name);
    }

    /**
     * 注册
     * @param timu
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("register")
    public  Object register(Timu timu)throws  Exception{
        if (timu.getName() == null || timu.getName() == ""){
            return  Message.getMessage(1,"非法注册",null);
        }else {
            Timu timu2 = service.verifyTimuName(timu.getName());
            if (timu2 != null) {
                return Message.getMessage(1, "账号已存在", null);
            }else {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");String format = simpleDateFormat.format(date);
                timu.setTime(format);
                timu.setPassword(MD5Utils.MD5(timu.getPassword()));
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                timu.setCreatetime(timestamp);
                System.err.println(timestamp);
                service.addTimu(timu);
                Timu time3 = service.findTimuById(timu.getId());
                time3.setId(time3.getId());
                return Message.getMessage(0, "注册成功", timu);
            }
        }
    }

    /**
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectStatus")
    public Object selectStatus(){
        Timu timu = (Timu) SecurityUtils.getSubject().getPrincipal();
        if (timu != null) {
            timu.setPassword("******");
        }
        return Message.getMessage(0,"",timu);
    }
}
