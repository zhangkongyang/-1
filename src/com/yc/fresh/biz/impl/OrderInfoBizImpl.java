package com.yc.fresh.biz.impl;

import java.util.List;
import java.util.Map;

import com.yc.fresh.biz.IOrderInfoBiz;
import com.yc.fresh.dao.IOrderInfoDao;
import com.yc.fresh.dao.impl.OrderInfoDaoImpl;
import com.yc.fresh.util.StringUtil;

public class OrderInfoBizImpl  implements IOrderInfoBiz{

	@Override
	public int add(String cnos, double totalPrice,String ano) {
		if(StringUtil.checkNull(cnos,ano)){
			return -1;
		}
		IOrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.add(cnos, totalPrice,ano);
	}

	@Override
	public List<Map<String, String>> finds(Integer mno) {
		IOrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
		return orderInfoDao.finds(mno);
	}

}
