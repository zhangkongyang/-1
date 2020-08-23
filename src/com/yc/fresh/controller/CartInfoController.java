package com.yc.fresh.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.fresh.biz.ICartInfoBiz;
import com.yc.fresh.biz.IMemberInfoBiz;
import com.yc.fresh.biz.impl.CartInfoBizImpl;
import com.yc.fresh.biz.impl.MemberInfoBizImpl;
import com.yc.fresh.entity.CartInfo;
import com.yc.fresh.entity.MemberInfo;
import com.yc.fresh.util.RequestParamUtil;

@WebServlet("/cart")
public class CartInfoController extends BasicServlet {
	private static final long serialVersionUID = 5365529159754433220L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op =request.getParameter("op");
		
		if("info".equals(op)){
			info(request,response);
		}else if ("update".equals(op)){
			update(request,response);
		}else if ("add".equals(op)){
			add(request,response);
		}else if ("find".equals(op)){
			find(request,response);
		}else if("findByCnos".equals(op)){
			findByCnos(request,response);
		}
		
	}

	private void findByCnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//查数据库
		String cnos = request.getParameter("cnos");
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		//this.send(response, 200,"",cartInfo);]
		this.send(response, 200,"",cartInfoBiz.findByCnos(cnos));
		
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null){
			this.send(response, 500,"",null);
			return;
		}
		//查数据库
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		MemberInfo mf = (MemberInfo) obj;
		this.send(response, 200,"",cartInfoBiz.finds(String.valueOf(mf.getMno())));
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
         CartInfo cf = RequestParamUtil.getParams(CartInfo.class, request);
         ICartInfoBiz cartinfobiz = new CartInfoBizImpl();
         String cno = UUID.randomUUID().toString().replace("-", "");
         cf.setCno(cno);
         int result  = cartinfobiz.add(cf);
         if(result >0){
        	 this.send(response, 200,cno,null);
         }else{
        	 this.send(response, 500,"",null);

         }
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cno = request.getParameter("cno");
		int num  = Integer.parseInt(request.getParameter("num"));
        ICartInfoBiz cartinfobiz = new CartInfoBizImpl();
        int result = cartinfobiz.updateNum(cno, num);
        if(result >0){
        	this.send(response, 200,"",null);
        }else{
        	this.send(response, 500,"",null);
        }
        

		
	}

	private void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("currentLoginMember");
		if(obj == null){
			this.send(response, 500,"",null);
			return;
		}
		//查数据库
		ICartInfoBiz cartInfoBiz = new CartInfoBizImpl();
		MemberInfo mf = (MemberInfo) obj;
		this.send(response, 200,"",cartInfoBiz.findCart(String.valueOf(mf.getMno())));
		
	}

	
	

}
