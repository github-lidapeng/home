package com.home.service;

import com.home.entity.PageBean;
import com.home.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<Student> findAll()throws  Exception;

    Integer addStudent(Student student);

    Student verifyByName(@Param("sname") String sname, @Param("tid") Integer tid);

    List<Student> findByTid(Integer tid);

    /**
     * 查询所有（分页）
     * @param currentPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageBean<Map<String,Object>> findByPage(int currentPage, int pageSize)throws Exception;
}
