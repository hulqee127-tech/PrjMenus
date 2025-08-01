<%@page import="menus.MenuDao"%>
<%@page import="menus.MenuDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	MenuDao dao = new MenuDao();
	ArrayList<MenuDto> menuList = dao.getMenuList();

	String html = "";
	for(int i = 0; i<menuList.size(); i++){
		
		MenuDto menu = menuList.get(i);		// 레코드 한줄을 의미  menu_id | menu_name | menu_seq
		html += "<tr>";
		html += "<td>"+menu.getMenu_id()+"</td>";
		html += "<td>"+menu.getMenu_name()+"</td>";
		html += "<td>"+menu.getMenu_seq()+"</td>";
		html += "<td><a href='delaction.jsp?menu_id="+menu.getMenu_id()+"'>삭제</a></td>";
		html += "<td><a href='updatemenu.jsp?menu_id="+menu.getMenu_id()+"'>수정</a></td>";
		html += "</tr>";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>메뉴 </h2>
	<table border="1" width="978">
		<tr>
			<td>Menu ID</td>
			<td>Menu NAME</td>
			<td>Menu SEQ</td>
			<td>^</td>
			<td>^</td>
		</tr>
		
		<tr>
			<td align="right" colspan="5">
				<a href="addmenu.jsp">메뉴추가</a>
			</td>
		</tr>
		<!-- 시작 -->
		<%=html %>		
		<!-- 끝 -->
	</table>
</body>
</html>