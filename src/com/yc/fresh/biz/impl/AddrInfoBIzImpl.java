package com.yc.fresh.biz.impl;

import java.util.Collections;
import java.util.List;

import com.yc.fresh.biz.IAddrInfoBiz;
import com.yc.fresh.dao.IAddrInfoDao;
import com.yc.fresh.dao.impl.AddrInfoDaoImpl;
import com.yc.fresh.entity.AddrInfo;
import com.yc.fresh.util.StringUtil;

public class AddrInfoBIzImpl implements IAddrInfoBiz{

	@Override
	public List<AddrInfo> finds(String mno) {
		if(StringUtil.checkNull(mno)){
			return Collections.emptyList();
		}
		IAddrInfoDao addrInfoDao = new AddrInfoDaoImpl();
		return addrInfoDao.finds(mno);
	}

}
