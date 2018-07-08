<!-- /inside view -->

<%@ page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html;charset=UTF-8">
<title>Admin Dashboard - Contact Application</title>
 <s:url var="url_css" value="/static/css/style.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css"/>

</head>
<s:url var="url_bg" value="/static/images/bg.jpg"/>
<body background="${url_bg}">
	<table border="1" width="80%" align="center">
		<tr>
			<td height="80px">
				<jsp:include page="include/header.jsp"></jsp:include>
			</td>
		</tr>

		<tr>
			<td height="25px">
			<!-- menu -->
			<jsp:include page="include/menu.jsp"></jsp:include>
			</td>
		</tr>

		<tr>
			<td height="350px" valign="top">
			<!--page content area  -->
			<h1>Admin Dashboard</h1>
			TODO: Admin Options in the page
			</td>
		</tr>

		<tr>
			<td height="25px">
			<!-- footer -->
			<jsp:include page="include/footer.jsp"></jsp:include>
			</td>
		</tr>

	</table>
</body>
</html>