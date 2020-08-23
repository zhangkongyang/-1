package com.yc.fresh.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.fresh.util.SessionKey;
import com.yc.fresh.util.StringUtil;


// 拦截所有请求
@WebFilter(filterName = "CheckBackLoginFilter", value = "/back/manager/*", initParams = @WebInitParam(name="errorpage", value="back/index.html"))
public class CheckBackLoginFilter implements Filter {
	private String path = "index.html";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String temp = filterConfig.getInitParameter("errorpage");
		if (!StringUtil.checkNull(temp)) {
			path = temp;
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		// 判断用户有没有登录 -> 如果登录了，则session中有当前登录用户的信息
		if (request.getSession().getAttribute(SessionKey.CURRENTLOGINADMIN) == null) { // 说明没有登录
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/";
			out.print("<script>alert('请先登录...'); location.href='" + basePath + path + "'</script>");
			out.flush();
			out.close();
		} else { // 如果登录了， 则将请求交个后面的过滤器	
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
