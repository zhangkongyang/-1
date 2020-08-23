package com.yc.fresh.biz;

import java.util.List;
import java.util.Map;

public interface IOrderInfoBiz {
	public int add(String cnos,double totalPrice,String ano); 
	/**
	 * 根据会员编号查询所有订单
	 * @param mno
	 * @return
	 */
	public List<Map<String,String>> finds(Integer mno);
	
	
}
