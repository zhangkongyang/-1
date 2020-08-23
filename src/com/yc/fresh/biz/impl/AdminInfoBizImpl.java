package com.yc.fresh.biz.impl;

import com.yc.fresh.biz.IAdminInfoBiz;
import com.yc.fresh.dao.IAdminInfoDao;
import com.yc.fresh.dao.impl.AdminInfoDaoImpl;
import com.yc.fresh.entity.AdminInfo;
import com.yc.fresh.util.StringUtil;

public class AdminInfoBizImpl implements IAdminInfoBiz{

	@Override
	public AdminInfo login(AdminInfo adminInfo) {
		if(StringUtil.checkNull(adminInfo.getAname(),adminInfo.getPwd())){
			return null;
		}
		IAdminInfoDao adminInfoDao = new AdminInfoDaoImpl();
		return adminInfoDao.login(adminInfo);
	}

}
