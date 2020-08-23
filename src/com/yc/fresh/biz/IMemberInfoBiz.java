package com.yc.fresh.biz;

import com.yc.fresh.entity.MemberInfo;

public interface IMemberInfoBiz {
	public  MemberInfo login(String account,String pwd);

}
