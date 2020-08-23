package com.yc.fresh.dao.impl;

import java.util.List;

import com.yc.fresh.dao.DBHelper;
import com.yc.fresh.dao.IGoodsTypeDao;
import com.yc.fresh.entity.GoodsType;

public class GoodsTypeDaoImpl implements IGoodsTypeDao {

	@Override
	public List<GoodsType> findAll() {
		DBHelper  db =new DBHelper();
		String sql ="select tno,tname,pic,status from goodstype";
		return db.finds(GoodsType.class, sql);
	}

	@Override
	public int update(GoodsType type) {
		DBHelper  db =new DBHelper();
		String sql="update goodstype set tname=?,pic=?,status=? where tno=?";
		return db.update(sql, type.getTname(),type.getPic(),type.getStatus(),type.getTno());
	}

	@Override
	public int add(GoodsType type) {
		DBHelper  db =new DBHelper();
		String sql ="insert into goodstype values(0,?,?,?)";
		return db.update(sql, type.getTname(),type.getPic(),type.getStatus());
	}

	@Override
	public int delete(String tno) {
		DBHelper  db =new DBHelper();
        String sql = "delete from goodstype where tno = ?";
		return db.update(sql, tno);
	}

}
