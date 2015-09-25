<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String actionName = request.getContextPath() + "/validation/add";
%>
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
	<h2>Order SignUp Form - JSR303 @Valid example</h2>
	<ul>
	<c:forEach var="item" items="${errorsList}" varStatus="status">
		<c:if test="${not empty item}">
			<li>order.${item.parameters[0]} ${item.code}</li>
		</c:if>
	</c:forEach>
	</ul>
	<form:form method="POST" commandName="order" action= "<%=actionName %>" >
		<table>
			<tr>
				<td>Order No :</td>
				<td><form:input path="orderNo" /></td>
				<td><form:errors path="orderNo" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Order Qty :</td>
				<td><form:input path="qty" /></td>
				<td><form:errors path="qty" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>