package com.home.dao;

import com.home.entity.Timu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李小末
 */
public interface ITimuDao {
    /**
     * 显示所有
     * @return
     * @throws Exception
     */
    List<Timu> findAll()throws Exception;

    /**
     * 添加
     * @param timu
     * @return
     * @throws Exception
     */
    Integer addTimu(Timu timu)throws Exception;

    /**
     * 重名验证
     * @param name
     * @return
     */
    Timu verifyTimuName(String name);

    /**
     * 通过id查询所有
     * @param id
     * @return
     */
    Timu findTimuById(Integer id);

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

    /**
     * 修改
     * @param timu
     * @return
     */
    Integer updateTimu(Timu timu);

    /**
     * 通过用户名和微信号进行模糊查询
     * @param timu
     * @return
     */
    List<Timu> fuzzyByName(Timu timu);
}
