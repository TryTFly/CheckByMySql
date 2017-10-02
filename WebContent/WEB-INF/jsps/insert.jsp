<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	/* out.print(path + "<br/>");
	out.print(basePath + "<br/>"); */
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>插入数据</title>
<style type="text/css">
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code,
	form, fieldset, legend, input, button, textarea, p, blockquote, th, td
	{
	margin: 0;
	padding: 0;
}

#p1, #p2 {
	color: red;
}

#container {
	width: 50%;
}

#body {
	width: 100%;
}

#t1 {
	width: 100%;
	height: 300px;
}

#t2 {
	width: 100%;
	height: 300px;
}

#footer {
	margin-left: 50%;
}
</style>
</head>
<body>
	<div id="container">
		<form action="<%=basePath%>InsertServlet.action" method="post">
			<p id="p1">表一((比较它不在表二中的数据)复制粘贴过来)</p>
			<div>
				<textarea id="t1" name="textarea1"></textarea>
			</div>
			<p id="p2">表二((被比较的表)复制粘贴过来)</p>
			<div id="body">
				<div id="header">
					<textarea id="t2" name="textarea2"></textarea>
				</div>
				<div id="footer">
					<input type="submit" name="submit" value="比对">
				</div>
			</div>
		</form>
	</div>
</body>
</html>