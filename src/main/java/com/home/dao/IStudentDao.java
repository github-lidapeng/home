package com.home.dao;

import com.home.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IStudentDao {
    List<Student> findAll()throws  Exception;

    Integer addStudent(Student student);

    /**
     * 多表重名验证（通过名字查找）
     * @param sname
     * @param tid
     * @return
     */
    Student verifyByName(@Param("sname") String sname, @Param("tid") Integer tid);

    /**
     * 通过外键id进行查询
     * @param tid
     * @return
     */
    List<Student> findByTid(Integer tid);

    /**
     * 查询所有信息（分页）
     * @param map
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> findByPage(HashMap<String,Object> map)throws Exception;

    /**
     * 查询记录总数
     * @return
     * @throws Exception
     */
    int selectCount()throws Exception;

}
