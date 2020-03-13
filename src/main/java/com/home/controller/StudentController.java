package com.home.controller;

import com.home.entity.PageBean;
import com.home.entity.Student;
import com.home.entity.Timu;
import com.home.service.StudentService;
import com.home.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("student")
/**
 *查询所有学生信息
 */
public class StudentController {
    @Autowired
    private StudentService service;

    @RequestMapping("showAll")
    @ResponseBody
    public Object showAll(@RequestParam(value = "currenPage",defaultValue = "1",required = false)int currenPage,@RequestParam(value = "pageSize",defaultValue = "5",required = false)int pageSize) throws Exception {
        List<Student> list = service.findAll();
        PageBean<Map<String, Object>> pagelist = service.findByPage(currenPage, pageSize);
        return Message.getMessage(0,"显示所有",pagelist);
    }

    /**
     *  添加学生信息
     * @param student
     * @return
     */
    @ResponseBody
    @RequestMapping("addStudent")
    public Object addStudent(Student student) throws ParseException {
        if (student != null){
            if (student.getSname() != null && !"".equals(student.getSname())){
                Student student2 = service.verifyByName(student.getSname(), student.getTid());
                if(student2 != null){
                    return Message.getMessage(403,"学生名名或题目名重复",null);
                }else {
                   /* Date date1 = new Date();
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String format1 = simpleDateFormat1.format(date1);
                    Date parse = simpleDateFormat1.parse(format1);*/
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    System.err.println(timestamp);

                    student.setCreatetime(timestamp);

                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String format = simpleDateFormat.format(date);
                    System.out.println(format);
                    student.setUpdatetime(format);
                    service.addStudent(student);
                    return Message.getMessage(1,"添加成功",student.getSname());
                }
            }else {
                return Message.getMessage(402,"学生名为空",null);
            }
        }
        return null;
    }

    /**
     * 通过外键题目id查询学生信息
     * @param student
     * @return
     */
    @RequestMapping("findByTid")
    @ResponseBody
    public Object findByTid(Student student){
        List<Student> list = service.findByTid(student.getTid());
        return Message.getMessage(0,"通过题目id查到的数据",list);
    }
}
