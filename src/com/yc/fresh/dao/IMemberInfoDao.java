package com.yc.fresh.dao;

import com.yc.fresh.entity.MemberInfo;

public interface IMemberInfoDao {
	public MemberInfo login(String account,String pwd);

}
