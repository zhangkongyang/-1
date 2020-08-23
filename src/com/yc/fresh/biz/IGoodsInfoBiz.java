package com.yc.fresh.biz;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.CartInfo;
import com.yc.fresh.entity.GoodsInfo;

public interface IGoodsInfoBiz {
	/**
	 * 分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<GoodsInfo> findByPage(int page,int rows);
	
	/**
	 * 查询总页数和 分页返回的记录  第一次分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String,Object> finds(int page,int rows);

	public Map<String,Object> findByCondition(String tno, String gname, int page, int rows);
	
	
	
	public Map<String,Object> findIndex();
	
public GoodsInfo findByGno(String gno);
	
	public List<GoodsInfo> findByTno(String tno,int page , int rows);
	
	public Map<String,Object> findByTnos(String tno,int page,int rows);
	
     /**
      * 添加商品信息
      * @param goods
      * @return
      */
	public int add(GoodsInfo goods);
	
	/**
	 * 更改商品信息
	 * @param goods
	 * @return
	 */
	public int update(GoodsInfo goods);

}
