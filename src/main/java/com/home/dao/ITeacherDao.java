package com.home.dao;

import com.home.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 李小末 on 2019/5/22 17:00
 */
public interface ITeacherDao {

    List<Teacher> findAll()throws Exception;

    List<Map<String,Object>> findByPage(HashMap<String,Object> map)throws Exception;

    int selectCount()throws Exception;

    Integer addTeacher(Teacher teacher);

    Teacher verifyName(@Param("tname")String sname,@Param("sid")Integer sid,@Param("tid")Integer tid);
}
