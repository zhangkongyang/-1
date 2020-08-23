package com.yc.fresh.biz.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yc.fresh.biz.IGoodsInfoBiz;
import com.yc.fresh.dao.IGoodsInfoDao;
import com.yc.fresh.dao.IGoodsTypeDao;
import com.yc.fresh.dao.impl.GoodsInfoDaoImpl;
import com.yc.fresh.dao.impl.GoodsTypeDaoImpl;
import com.yc.fresh.entity.CartInfo;
import com.yc.fresh.entity.GoodsInfo;
import com.yc.fresh.util.StringUtil;

public class GoodsInfoBizImpl implements IGoodsInfoBiz {

	@Override
	public List<GoodsInfo> findByPage(int page, int rows) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.findBypage(page, rows);
	}

	@Override
	public Map<String, Object> finds(int page, int rows) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", goodsInfoDao.total());
		map.put("rows", goodsInfoDao.findBypage(page, rows));
		return map;

	}

	@Override
	public Map<String, Object> findByCondition(String tno, String gname, int page, int rows) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", goodsInfoDao.total(tno, gname));
		map.put("rows", goodsInfoDao.findByCondition(tno, gname, page, rows));

		return map;
	}

	@Override
	public Map<String, Object> findIndex() {
		Map<String, Object> map = new HashMap<String, Object>();
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		IGoodsTypeDao typedao = new GoodsTypeDaoImpl();
		map.put("types", typedao.findAll());
		map.put("goods", goodsInfoDao.findIndex());
		return map;

	}

	// 通过商品编号查询商品
	public GoodsInfo findByGno(String gno) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.findByGno(gno);
	}

	@Override
	public List<GoodsInfo> findByTno(String tno, int page, int rows) {
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.findByTno(tno, page, rows);
	}

	@Override
	public Map<String, Object> findByTnos(String tno, int page, int rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		map.put("total", goodsInfoDao.total(tno));
		map.put("rows", goodsInfoDao.findByTno(tno, page, rows));
		return map;
	}

	@Override
	// 添加商品信息
	public int add(GoodsInfo goods) {
		if (StringUtil.checkNull(goods.getGname(), goods.getTno(), goods.getPrice(), goods.getIntro(),
				goods.getBalance(), goods.getPics(), goods.getUnit(), goods.getQperied(), goods.getWeight(),
				goods.getDescr())) {
			return -1;
		}
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.add(goods);

	}

	@Override
	public int update(GoodsInfo goods) {
		if(StringUtil.checkNull(goods.getGname(),goods.getPrice(),goods.getIntro(),goods.getBalance(),goods.getUnit(),goods.getQperied(),goods.getWeight(),goods.getDescr(),goods.getGno())){
			return -1;
		}
		IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
		return goodsInfoDao.update(goods);
	}

}
