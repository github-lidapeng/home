package com.home.serviceimpl;

import com.home.dao.ITimuDao;
import com.home.entity.PageBean;
import com.home.entity.Timu;
import com.home.service.TimuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TimuServiceImpl implements TimuService {
    @Autowired
    private ITimuDao dao;

    @Override
    public List<Timu> fuzzyByName(Timu timu) {
        return dao.fuzzyByName(timu);
    }

    @Override
    public Integer updateTimu(Timu timu) {
        return dao.updateTimu(timu);
    }

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
    public Integer addTimu(Timu timu) throws Exception {
        return dao.addTimu(timu);
    }

    @Override
    public Timu findTimuById(Integer id) {
        return dao.findTimuById(id);
    }

    @Override
    public Timu verifyTimuName(String name) {
        return dao.verifyTimuName(name);
    }

    @Override
    public List<Timu> findAll() throws Exception {
        return dao.findAll();
    }

}
