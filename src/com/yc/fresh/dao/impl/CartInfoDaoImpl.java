package com.yc.fresh.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.fresh.dao.DBHelper;
import com.yc.fresh.dao.ICartInfoDao;
import com.yc.fresh.entity.CartInfo;

public class CartInfoDaoImpl  implements ICartInfoDao{

	@Override
	public List<Map<String, Object>> findCart(String mno) {
		DBHelper db = new DBHelper();
		String sql = "select cno,gno from cartinfo where mno=?";
		return db.finds(sql, mno);
	}

	@Override
	public List<CartInfo> finds(String mno) {
		DBHelper db = new DBHelper();
		String sql = "select cno,c.gno,num,price,pics,gname,unit,weight from cartinfo c,goodsinfo g where c.gno = g.gno and mno=?";
		return db.finds(CartInfo.class, sql,mno);
	}

	@Override
	public int updateNum(String cno, int num) {
		DBHelper db = new DBHelper();
		String sql = "update cartinfo set num = num + ? where cno=?";
		return db.update(sql, num,cno);
	}

	@Override
	public int add(CartInfo cf) {
		DBHelper db = new DBHelper();
		String sql = "insert into cartinfo values(?,?,?,?)";
		return db.update(sql, cf.getCno(),cf.getMno(),cf.getGno(),cf.getNum());
	}

	@Override
	public int delete(String[] cnos) {
		DBHelper db = new DBHelper();
		String sql = "delete from cartinfo where cno in(";
		List<Object> params = new ArrayList<Object>();
		for(String cno:cnos){
			sql +="?,";
			params.add(cno);
		}
		sql +=sql.substring(0,sql.lastIndexOf(","))+")";
		
		return db.update(sql, params);
		
	}

	@Override
	public int delete(String cno) {
		DBHelper db = new DBHelper();
		String sql = "delete from cartinfo where cno=?";
		return db.update(sql, cno);
	}

	@Override
	public List<CartInfo> findByCnos(String[] cnos) {
		DBHelper db = new DBHelper();
		String sql ="select cno,c.gno,num,price,pics,gname,unit,weight from cartinfo c,goodsinfo g where c.gno=g.gno and cno in(";
		List<Object> params = new ArrayList<Object>();
		for(String cno: cnos){
			sql +="?,";
			params.add(cno);
		}
		sql = sql.substring(0,sql.lastIndexOf(",")) +")";

		return db.finds(CartInfo.class,sql,params);
	}

	

}
