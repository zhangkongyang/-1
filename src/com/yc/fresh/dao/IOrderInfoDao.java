package com.yc.fresh.dao;

import java.util.List;
import java.util.Map;

public interface IOrderInfoDao {
	public int add(String cnos,double totalPrice,String ano);
	
	
	/**
	 * 根据会员编号查询所有订单
	 * @param mno
	 * @return
	 */
	public List<Map<String, String>> finds(Integer mno);

}
