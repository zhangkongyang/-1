package com.yc.fresh.dao.impl;

import java.util.List;

import com.yc.fresh.dao.DBHelper;
import com.yc.fresh.dao.IAddrInfoDao;
import com.yc.fresh.entity.AddrInfo;

public class AddrInfoDaoImpl implements IAddrInfoDao{

	@Override
	public List<AddrInfo> finds(String mno) {
		DBHelper db = new DBHelper();
		String sql = "select ano,mno,name,tel,province,city,area,addr,flag from addrinfo where status !=0 and mno=?";
		return db.finds(AddrInfo.class, sql,mno);
	}

}
