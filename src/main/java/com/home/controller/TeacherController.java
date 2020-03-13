package com.home.controller;

import com.home.entity.PageBean;
import com.home.entity.Teacher;
import com.home.service.TeacherService;
import com.home.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by 李小末 on 2019/5/22 17:08
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService service;

    /**
     * 显示所有
     * @param currentPage 当前页
     * @param pageSize 当前页显示的数量
     * @return
     * @throws Exception
     */
    @RequestMapping("showAll")
    @ResponseBody
    public Object showAll(@RequestParam(value = "currentPage",defaultValue = "1",required = false)int currentPage,@RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize) throws Exception {
        PageBean<Map<String, Object>> pageList = service.findByPage(currentPage, pageSize);
        return Message.getMessage(0,"查询所有",pageList);
    }

    @ResponseBody
    @RequestMapping("addTeacher")
    public Object addTeacher(Teacher teacher){
        if (teacher != null){

            if (teacher.getTname() != null && !"".equals(teacher.getTname())){
                Teacher teacher2 = service.verifyName(teacher.getTname(), teacher.getSid(), teacher.getTid());
                if (teacher2 !=null){
                    return Message.getMessage(403,"重复了",teacher2.getTname());
                }else {
                    return Message.getMessage(0,"添加成功",service.addTeacher(teacher));
                }
            }else {
                return Message.getMessage(402,"名字为空",null);
            }
        }
    return Message.getMessage(555,"",null);
}
}
