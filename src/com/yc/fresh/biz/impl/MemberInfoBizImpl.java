package com.yc.fresh.biz.impl;

import com.yc.fresh.biz.IMemberInfoBiz;
import com.yc.fresh.dao.IMemberInfoDao;
import com.yc.fresh.dao.impl.MemberInfoDaoImpl;
import com.yc.fresh.entity.MemberInfo;
import com.yc.fresh.util.StringUtil;

public class MemberInfoBizImpl implements IMemberInfoBiz{

	@Override
	public MemberInfo login(String account, String pwd) {
		if(StringUtil.checkNull(account,pwd)){
			return null;
		}
		IMemberInfoDao memberInfoDao = new MemberInfoDaoImpl();
		return memberInfoDao.login(account, pwd);
	}

}
