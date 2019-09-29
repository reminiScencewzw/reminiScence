<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.yunhe.controller.*,cn.yunhe.entity.*,java.lang.Integer,java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
	//先获取标识,判断当前的操作类型
	String type = request.getParameter("type");
	
	MotifController motifController = new MotifController();
	if("add".equals(type)){
		String motifName = new String(request.getParameter("motifName").getBytes("iso-8859-1"),"utf-8");
		Motif motif = new Motif();
		motif.setMotif(motifName);
		int result = motifController.addMotif(motif);
		if(result == 1){
			response.sendRedirect("motif-list.jsp");
		}else{
			out.println("<javascript>alert('添加失败')</javascript>");
			response.sendRedirect("motif-list.jsp");
		}
	}else if("change".equals(type)){
		String id = request.getParameter("id");
		String motifName = new String(request.getParameter("motifName").getBytes("iso-8859-1"),"utf-8");
	    motifController.changeMotifName(Integer.valueOf(id), motifName);
	}
	else if("updatesta".equals(type)){
		String id = request.getParameter("id");
		String state = request.getParameter("state");
		state = String.valueOf(Integer.valueOf(state)==0?1:0);
		motifController.delMotifById(state,Integer.valueOf(id));
		response.sendRedirect("motif-list.jsp");
	}else if("query".equals(type)){
		//获取数据总条数
		int total = motifController.getCount();
		//每页展示的数据条数
		int pageCount = 3;
		//默认页码
		int pageIndex = 1;
		//获取分页的页码数
		String newPageIndex = request.getParameter("pageIndex");
		if(newPageIndex != null){
			pageIndex = Integer.valueOf(newPageIndex);
		}
		List<Motif> motifList = motifController.queryMotifList(pageCount, pageIndex);
		//将分页相关的数据封装到对象中
		Paging paging = new Paging();
		paging.setPageCount(pageCount);
		paging.setTotal(total);
		paging.setPageIndex(pageIndex);
		paging.setList(motifList);
		
		session.setAttribute("paging", paging);
		response.sendRedirect("motif-list.jsp");
	}
%>