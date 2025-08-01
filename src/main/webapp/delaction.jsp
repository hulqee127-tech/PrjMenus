<%@ page import="menus.MenuDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// addmenu.jsp 가 보내준 data 를 받는다
	String menu_id = request.getParameter("menu_id");
	
	
	//삭제한다.
	MenuDao menuDao = new MenuDao();
	// ↑ MenuDao cannot be resolved to a type 발생 
	//		==> Ctrl + Shift + m 해서 import 시켜 준다.
	menuDao.delMenu(menu_id);
	
	//목록으로 돌아간다.
	String loc = "menulist.jsp";
	response.sendRedirect(loc);
%>