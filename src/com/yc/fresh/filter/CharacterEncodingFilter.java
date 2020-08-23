package com.yc.fresh.filter;

import java.io.IOException;

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

import com.yc.fresh.util.StringUtil;

// 拦截所有请求
@WebFilter(filterName = "CharacterEncodingFilter", value = "/*", initParams = @WebInitParam(name="encoding", value="utf-8"))
public class CharacterEncodingFilter implements Filter {
	private String encoding = "utf-8";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String temp = filterConfig.getInitParameter("encoding");
		if (!StringUtil.checkNull(temp)) {
			encoding = temp;
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		// 将这个请求传递给后面的过滤器 -> 调用过滤器链中的下一个过滤器过滤
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
