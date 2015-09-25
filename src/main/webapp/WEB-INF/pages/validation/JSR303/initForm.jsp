<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
String actionName = request.getContextPath() + "/user/add";
%>

<%--
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
out.println(path);
out.println(basePath);
--%>

<html>
<head>
<style>
.error {
	color: #ff0000;
}
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<h2>User SignUp Form - JSR303 @Valid example</h2>
	<form:form method="POST" commandName="user" action= "<%=actionName %>" >
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>User Name :</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>User Age :</td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>