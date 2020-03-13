package com.home.service;

import com.home.entity.PageBean;
import com.home.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by 李小末 on 2019/5/22 17:01
 */
public interface TeacherService {
    /**
     * 显示所有
     * @return
     */
    List<Teacher> findAll()throws Exception;

    PageBean<Map<String,Object>> findByPage(int currentPage, int pageSize)throws Exception;

    Integer addTeacher(Teacher teacher);

    Teacher verifyName(@Param("tname")String sname, @Param("sid")Integer sid, @Param("tid")Integer tid);

}
