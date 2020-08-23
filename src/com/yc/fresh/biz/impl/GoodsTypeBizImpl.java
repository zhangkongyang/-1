package com.yc.fresh.biz.impl;

import java.util.List;

import com.yc.fresh.biz.IGoodsTypeBiz;
import com.yc.fresh.dao.IGoodsTypeDao;
import com.yc.fresh.dao.impl.GoodsTypeDaoImpl;
import com.yc.fresh.entity.GoodsType;
import com.yc.fresh.util.StringUtil;

public class GoodsTypeBizImpl implements IGoodsTypeBiz {

	@Override
	public List<GoodsType> findAll() {
		IGoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.findAll();
	}

	@Override
	public int update(GoodsType type) {
		if (StringUtil.checkNull(type.getTname(), type.getPic())) {
			return -1;
		}
		IGoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.update(type);

	}

	@Override
	public int add(GoodsType type) {
		if (StringUtil.checkNull(type.getTname(), type.getPic())) {
			return -1;
		}
		IGoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.add(type);
	}

	@Override
	public int delete(String tno) {
		if (StringUtil.checkNull(tno)) {
			return -1;
		}
		IGoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
		return goodsTypeDao.delete(tno);
	}

}
