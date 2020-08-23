package com.yc.fresh.dao;

import java.util.List;

import com.yc.fresh.entity.GoodsType;

public interface IGoodsTypeDao {
	
	/**
	 * 查询所有类型
	 * @return
	 */
	public List<GoodsType> findAll();
	
	/**
	 * 修改
	 * @param type
	 * @return
	 */
    public int update(GoodsType type);
    
    /**
     * 添加
     * @param type
     * @return
     */
    public int add(GoodsType type);
    /**
     * 删除
     * @param tno
     * @return
     */
    
    public int delete(String tno);

}
