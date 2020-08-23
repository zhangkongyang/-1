package com.yc.fresh.dao;

import java.util.List;

import com.yc.fresh.entity.AddrInfo;

public interface IAddrInfoDao {
	public List<AddrInfo> finds(String mno);

}
