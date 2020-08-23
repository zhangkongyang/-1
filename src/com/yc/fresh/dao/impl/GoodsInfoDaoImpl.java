package com.yc.fresh.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.fresh.dao.DBHelper;
import com.yc.fresh.dao.IGoodsInfoDao;
import com.yc.fresh.entity.GoodsInfo;
import com.yc.fresh.util.StringUtil;

public class GoodsInfoDaoImpl  implements IGoodsInfoDao{

	@Override
	public List<GoodsInfo> findBypage(int page, int rows) {
		DBHelper db = new  DBHelper();
		String sql = "select gno,g.tno,tname,gname,price,concat(balance,'/',unit) unit,g.pics, intro from goodsinfo g, "
				+" goodstype t where g.tno=t.tno order by gno desc limit ?,?";
		return db.finds(GoodsInfo.class, sql,(page-1)*rows,rows);
	}

	@Override
	public int total() {
		DBHelper db = new  DBHelper();
		String sql ="select count(gno) from goodsinfo";
		return db.total(sql);
	}

	@Override
	public int total(String tno, String gname) {
		DBHelper db = new  DBHelper();
		String sql ="select count(gno) from goodsinfo where 1=1 ";
		List<Object> params = new ArrayList<Object>();
		if(!StringUtil.checkNull(tno)){
			sql += " and tno = ? ";
			params.add(tno);
		}
		
		if(!StringUtil.checkNull(gname)){
			sql += " and gname like concat('%', ?, '%') ";
			params.add(gname);
		}
		return db.total(sql, params);
	}

	@Override
	public List<GoodsInfo> findByCondition(String tno, String gname, int page, int rows) {
		DBHelper db = new  DBHelper();
		String sql ="select gno,g.tno,tname,gname,price,concat(balance,'/',unit) unit,intro from goodsinfo g, goodstype t  "
				+" where g.tno=t.tno";
		List<Object> params = new ArrayList<Object>();
		if(!StringUtil.checkNull(tno)){
			sql += " and g.tno = ? ";
			params.add(tno);
		}
		
		if(!StringUtil.checkNull(gname)){
			sql += " and gname like concat('%', ?, '%') ";
			params.add(gname);
		}
		sql += " order by gno desc limit ?, ?";
		params.add((page-1)*rows);
		params.add(rows);
		return db.finds(GoodsInfo.class, sql,params);
	}

	@Override
	public List<GoodsInfo> findIndex() {
		DBHelper db = new  DBHelper();
		String sql = "select gno,gname,price,tno,pics from goodsinfo g1  where 4 >(select count(gno) from "
				+" goodsinfo g2 where g1.tno = g2.tno and g1.gno<g2.gno) order by g1.tno asc, g1.gno desc";
		return db.finds(GoodsInfo.class, sql);
	}

	//通过商品编号查询商品
	public GoodsInfo findByGno(String gno) {
		DBHelper db = new  DBHelper();
		String sql = "select gno,gname,price,intro,balance,pics,unit,weight,qperied,descr from goodsinfo where gno = ? ";
		return db.find(GoodsInfo.class,sql,gno);
	}

	@Override
	public List<GoodsInfo> findByTno(String tno, int page, int rows) {
		DBHelper db = new  DBHelper();
		String sql ="select gno,gname,price,pics,unit,weight from goodsinfo where tno=? order by gno desc limit ?,?";
		return db.finds(GoodsInfo.class, sql,tno,(page-1)*rows,rows);
	}

	@Override
	public int total(String tno) {
		DBHelper db = new  DBHelper();
		String sql ="select count(gno) from goodsinfo where tno =?";
		return db.total(sql, tno);
	}

	@Override
	public int add(GoodsInfo goods) {
		DBHelper db = new  DBHelper();
		String sql ="insert into goodsinfo(gname,tno,price,intro,balance,pics,unit,qperied,weight,descr)  values(?,?,?,?,?,?,?,?,?,?)";
		return db.update(sql, goods.getGname(),goods.getTno(),goods.getPrice(),goods.getIntro(),goods.getBalance(),goods.getPics(),goods.getUnit(),goods.getQperied(),goods.getWeight(),goods.getDescr());
	}

	//更改商品信息
	public int update(GoodsInfo goods) {
		DBHelper db = new  DBHelper();
		String sql = "update goodsinfo set gname=?,price=?,intro=?,balance=?,unit=?,qperied=?,weight=?,descr=? where gno = ?";
		return db.update(sql, goods.getGname(),goods.getPrice(),goods.getIntro(),goods.getBalance(),goods.getUnit(),goods.getQperied(),goods.getWeight(),goods.getDescr(),goods.getGno());
	}

	

}
