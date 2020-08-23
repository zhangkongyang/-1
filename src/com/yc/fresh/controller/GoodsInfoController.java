package com.yc.fresh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.yc.fresh.biz.IGoodsInfoBiz;
import com.yc.fresh.biz.impl.GoodsInfoBizImpl;
import com.yc.fresh.entity.GoodsInfo;
import com.yc.fresh.util.FileUploadUtil;
import com.yc.fresh.util.RequestParamUtil;

@WebServlet("/goods")
public class GoodsInfoController extends BasicServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String op = request.getParameter("op");
		 
		if("finds".equals(op)){
			finds(request,response);
		}else if ("findBypage".equals(op)){
			findBypage(request,response);
		}else if("findByCondition".equals(op)){
			findByCondition(request,response);
		}else if ("findIndex".equals(op)){
			findIndex(request,response);
		} else if("findByGno".equals(op)){
			findByGno(request,response);
		}else if("findByTnos".equals(op)){
			findByTnos(request,response);
		}else if("findByTno".equals(op)){
			findByTno(request,response);
		}else if("add".equals(op)){  //添加商品信息   来源：view_goods.html 
			try {
				add(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if("update".equals(op)){   //修改商品信息 来源于view_goods.html
			update(request,response);
		}
	}
     //修改商品信息   
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		GoodsInfo goodsinfo = RequestParamUtil.getParams(GoodsInfo.class, request);
	       IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
         int  result =-1;
         result =goodsInfoBiz.update(goodsinfo);
         this.send(response, result);
         
		
	}

	//添加商品信息
	private void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FileUploadUtil fuu = new FileUploadUtil();
		PageContext pagecontext = JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true,
				2048, true);
        GoodsInfo goodsinfo =fuu.upload(GoodsInfo.class, pagecontext);
       System.out.println(goodsinfo);
       IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
       int result =-1;
        result= goodsInfoBiz.add(goodsinfo);
        this.send(response, result);
      }
	 

	private void findByTno(HttpServletRequest request, HttpServletResponse response) throws IOException {
		   String tno = request.getParameter("tno");
		   int page = Integer.parseInt(request.getParameter("page"));
		   int rows = Integer.parseInt(request.getParameter("rows"));
		   IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		   this.send(response, 200, "", goodsInfoBiz.findByTno(tno, page, rows));
	}

	private void findByTnos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		   String tno = request.getParameter("tno");
		   int page = Integer.parseInt(request.getParameter("page"));
		   int rows = Integer.parseInt(request.getParameter("rows"));
		   IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		   this.send(response, 200, "", goodsInfoBiz.findByTnos(tno, page, rows));		
	}

	private void findByGno(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String gno = request.getParameter("gno");
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, 200,"",goodsInfoBiz.findByGno(gno));

 		
	}

	private void findIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, 200,"",goodsInfoBiz.findIndex());
		
	}

	private void findByCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows =Integer.parseInt(request.getParameter("rows"));
		String tno = request.getParameter("tno");
		String gname = request.getParameter("gname");
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, goodsInfoBiz.findByCondition(tno,gname,page, rows));
		
	}

	private void findBypage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows =Integer.parseInt(request.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, goodsInfoBiz.findByPage(page, rows));
		
	}

	private void finds(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows =Integer.parseInt(request.getParameter("rows"));
		IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
		this.send(response, goodsInfoBiz.finds(page, rows));		
	}

}
