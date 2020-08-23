package com.yc.fresh.dao.impl;

import com.yc.fresh.dao.DBHelper;
import com.yc.fresh.dao.IMemberInfoDao;
import com.yc.fresh.entity.MemberInfo;

public class MemberInfoDaoImpl implements IMemberInfoDao{

	@Override
	public MemberInfo login(String account, String pwd) {
		DBHelper db = new DBHelper();
		String sql ="select mno,nickName,realName,tel,email from memberinfo where (nickName=? or tel = ? or email =?) and pwd=md5(?)";
		return db.find(MemberInfo.class, sql,account,account,account,pwd);
	}

}
