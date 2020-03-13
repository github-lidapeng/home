package com.home.service;

import com.home.entity.PageBean;
import com.home.entity.Timu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TimuService {
    /**
     * 显示所有的信息
     * @return
     * @throws Exception
     */
    List<Timu> findAll() throws  Exception;

    /**添加
     *
     * @param timu
     * @return
     * @throws Exception
     */
    Integer addTimu(Timu timu)throws Exception;

    /**
     * 重名验证
     * @param name
     * @return
     * @throws Exception
     */
    Timu verifyTimuName(String name);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    Timu findTimuById(Integer id);

    /**
     * 查询所有（分页）
     * @param currentPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageBean<Map<String,Object>> findByPage(int currentPage, int pageSize)throws Exception;

    /**
     * 修改
     * @param timu
     * @return
     */
    Integer updateTimu(Timu timu);

    /**
     * 通过名字进行模糊查询
     * @param map
     * @return
     */
    List<Timu> fuzzyByName(Timu timu);
}
