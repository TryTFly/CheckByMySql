<%@page import="com.y.model.TextArea1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.y.model.LoginDemoTable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("utf-8");
	ArrayList<TextArea1> list = (ArrayList) request.getAttribute("list");
	StringBuffer buffer = new StringBuffer();
	for (int i = 0; i < list.size(); i++) {
		buffer.append(list.get(i).getOdNumber() + "\n");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

#container {
	width: 50%;
	height: 50%;
}

#header {
	width: 100%;
	height: 500px;
}

#ta {
	width: 100%;
	height: 100%;
}

#footer {
	margin-left: 50%;
}
</style>
</head>
<body>
	<div id="container">
		<div id="header">
			<textarea id="ta"><%=buffer.toString()%></textarea>
		</div>
		<div id="footer">
			<a href="<%=basePath%>CheckServlet.action">点击返回</a>
		</div>
	</div>
</body>
</html>