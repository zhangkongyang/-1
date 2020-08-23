package com.yc.fresh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.fresh.biz.IAdminInfoBiz;
import com.yc.fresh.biz.impl.AdminInfoBizImpl;
import com.yc.fresh.entity.AddrInfo;
import com.yc.fresh.entity.AdminInfo;
import com.yc.fresh.util.RequestParamUtil;
import com.yc.fresh.util.SessionKey;

@WebServlet("/admin")
public class AdminInfoController extends BasicServlet {
	private static final long serialVersionUID = 6411179063452209631L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("login".equals(op)){          //管理员登陆
			login(request,response);
		}else if("info".equals(op)){    //获取管理员账户信息
			info(request,response);

		}
	
	}

	private void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(SessionKey.CURRENTLOGINADMIN);
		this.send(response, obj);
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		        // 获取参数
	        	AdminInfo af = RequestParamUtil.getParams(AdminInfo.class, request);
				
				// 调用业务层处理
				IAdminInfoBiz adminInfoBiz = new AdminInfoBizImpl();
				af = adminInfoBiz.login(af);
				
				// 返回结果
				if (af == null) { // 说明登录失败
					this.send(response, 500);
				} else { // 说明登录成功
					// 将当前登录用户存到session，便于后面的页面获取
					HttpSession session = request.getSession();
					session.setAttribute(SessionKey.CURRENTLOGINADMIN, af);
					
					this.send(response, 200);
				}
	}

}
