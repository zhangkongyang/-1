package com.yc.fresh.dao;

import com.yc.fresh.entity.AdminInfo;

public interface IAdminInfoDao {
	
	/**
	 * 管理员登陆信息
	 * @param adminInfo
	 * @return
	 */
	public AdminInfo login(AdminInfo adminInfo);

}
