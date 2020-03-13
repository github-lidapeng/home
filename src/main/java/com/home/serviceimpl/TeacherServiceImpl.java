package com.home.serviceimpl;

import com.home.dao.ITeacherDao;
import com.home.entity.PageBean;
import com.home.entity.Teacher;
import com.home.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 李小末 on 2019/5/22 17:02
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private ITeacherDao dao;

    @Override
    public PageBean<Map<String, Object>> findByPage(int currentPage, int pageSize) throws Exception {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Map<String, Object>> pageBean = new PageBean<Map<String,Object>>();

        //封装当前页数
        pageBean.setCurrentPage(currentPage);

        //每页显示的数据
        //int pageSize=10;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = dao.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        //向上取整
        Double num =Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<Map<String,Object>> lists = dao.findByPage(map);
        pageBean.setLists(lists);
        return pageBean;
    }

    @Override
    public Integer addTeacher(Teacher teacher) {
        return dao.addTeacher(teacher);
    }

    @Override
    public Teacher verifyName(String sname, Integer sid, Integer tid) {
        return dao.verifyName(sname,sid,tid);
    }

    @Override
    public List<Teacher> findAll() throws Exception {
        return dao.findAll();
    }
}
