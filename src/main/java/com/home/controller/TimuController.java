package com.home.controller;
import com.home.entity.PageBean;
import com.home.entity.Timu;
import com.home.service.TimuService;
import com.home.utils.MD5Utils;
import com.home.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("timu")
/**
 * @author 李小末
 */
public class TimuController {

    @Autowired
    private TimuService service;

    /**
     *
     * @param currentPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("showAll")
    public Map<String,Object> showAll(@RequestParam(value = "currentPage",defaultValue = "1",required = false)int currentPage,@RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize) throws Exception {
            System.err.println("11111111111111111111111");
        List<Timu> list = service.findAll();
        PageBean<Map<String, Object>> pageList = service.findByPage(currentPage, pageSize);
        System.err.println("222222222222222222222222222");
        return Message.getMessage(555,"显示所有",pageList);
    }

    /**
     * 添加
     * @param timu
     * @return
     * @throws Exception
     */
    @RequestMapping("addTimu")
    @ResponseBody
    public Map<String,Object> addTimu(Timu timu)throws Exception{
            if(timu !=null){
                if(timu.getName() !=null && !"".equals(timu.getName())){
                    Timu timu1 = service.verifyTimuName(timu.getName());
                    if (timu1 !=null){
                        return Message.getState(402,"名字重复了哦");
                    }else {
                       /* System.err.println(new Date());
                        Date date = new Date();
                        SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        String date2 = temp.format(date);
                        System.err.println(date2);
                        Date parse = temp.parse(date2);
                        timu.setPlayTime(parse);*/
                        Date date = new Date();
                        SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String date2 = temp.format(date);
                        System.err.println(date2);
                        Date parse = temp.parse(date2);
                       timu.setCreatetime(new Date());
                       timu.setTime(date2);
                        timu.setPassword(MD5Utils.MD5(timu.getPassword()));
                        return Message.getMessage(666,"添加成功",service.addTimu(timu));
                    }
                }else {
                    return Message.getState(403,"用户名为空");
                }
            }
            return null;
    }

    /**
     * 修改
     * @param timu
     * @return
     */
    @RequestMapping("updateTimu")
    @ResponseBody
    public Object updateTimu(Timu timu){
        if (timu != null){
            if (timu.getName() != null && !"".equals(timu.getName())){
                Timu timu2 = service.verifyTimuName(timu.getName());
                if (timu2 != null){
                    return Message.getMessage(403,"用户名重复",timu2.getName());
                }else {
                    return Message.getMessage(0,"修改成功",service.updateTimu(timu));
                }
            }else {
                return Message.getMessage(402,"用户名为空",null);
            }
        }
        return null;
    }

    /**
     * 通过用户名 微信号进行模糊查询
     * @param timu
     * @return
     */
    @ResponseBody
    @RequestMapping("fuzzyByName")
    public Object fuzzyByName(Timu timu){
        List<Timu> list = service.fuzzyByName(timu);
        return Message.getMessage(0,"查到的信息",list);
    }

}
