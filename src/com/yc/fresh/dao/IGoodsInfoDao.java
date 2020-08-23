package com.yc.fresh.dao;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entity.GoodsInfo;

public interface IGoodsInfoDao {
	/**
	 * 分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<GoodsInfo> findBypage(int page,int rows);
	
	/**
	 * 查询数量
	 * @return
	 */
	public int total();

	public int total(String tno, String gname);

	public  List<GoodsInfo> findByCondition(String tno, String gname, int page, int rows);
	/**
	 * 查询返回前4个的数据
	 * @return
	 */
	public List<GoodsInfo> findIndex();
	
	public GoodsInfo findByGno(String gno);
	
	public List<GoodsInfo> findByTno(String tno,int page , int rows);
	
	public int total(String tno);
	
	
	public int add(GoodsInfo goods);
	
	/**
	 * 更改商品信息
	 * @param goods
	 * @return
	 */
	public int update(GoodsInfo goods);

}
