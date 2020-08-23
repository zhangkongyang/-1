package com.yc.fresh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.fresh.biz.IAddrInfoBiz;
import com.yc.fresh.biz.impl.AddrInfoBIzImpl;
import com.yc.fresh.entity.AddrInfo;
import com.yc.fresh.entity.MemberInfo;

@WebServlet("/addr")
public class AddrInfoController extends BasicServlet {
	private static final long serialVersionUID = 5470328105257780924L;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		
		if("find".equals(op)){
			find(request,response);
		}
	}


	private void find(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		HttpSession session = request.getSession();		
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null){
			this.send(response, 500,"",null);
			return;
		}
		
		//查数据库
		MemberInfo mf = (MemberInfo) obj;
      IAddrInfoBiz addrInfoBiz = new AddrInfoBIzImpl();
      List<AddrInfo> addrs = addrInfoBiz.finds(String.valueOf(mf.getMno()));
      if(addrs !=null && !addrs.isEmpty()){
    	  this.send(response, 200,null,addrs);
    	  return;
      }
      this.send(response, 500,null,null);
	}

}
