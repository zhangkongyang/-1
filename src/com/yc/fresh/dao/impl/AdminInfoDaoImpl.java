package com.yc.fresh.dao.impl;

import com.yc.fresh.dao.DBHelper;
import com.yc.fresh.dao.IAdminInfoDao;
import com.yc.fresh.entity.AdminInfo;

public class AdminInfoDaoImpl  implements IAdminInfoDao{

	@Override
	public AdminInfo login(AdminInfo adminInfo) {
		DBHelper db = new DBHelper();
		String sql= "select aid,aname,pwd,tel from admininfo where aname=? and pwd =?";
		return db.find(AdminInfo.class, sql, adminInfo.getAname(),adminInfo.getPwd());
	}

}
