<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

#contact-form {
    background-color:#F2F7F9;
    width:800px;
    padding:20px;
    margin: 50px auto;    
    border: 2px solid #8FB5C1;
    -moz-border-radius:15px;
    -webkit-border-radius:15px;
    border-radius:15px;
    position:relative;
}

#contact-form h1 {
    font-size:42px;
}
 
#contact-form h2 {
    margin-bottom:15px;
    font-style:italic;
    font-weight:normal;
}
 
#contact-form input, 
#contact-form select, 
#contact-form textarea, 
#contact-form label {
    font-size:15px;
    margin-bottom:2px;
}

#contact-form select, 
#contact-form textarea{
    font-size:15px;
    margin-bottom:2px;
    width:437px;
}

#contact-form input:focus, 
#contact-form select:focus, 
#contact-form textarea:focus,
#contact-form input[type="text"],
#contact-form input[type="password"],
#contact-form select,
#contact-form textarea{
    border: 1px solid #AFCDD8;
    background-color: #EBF2F4;
}
 
#contact-form textarea {
    height:75px;
    width:437px;
    resize: none;
}
 
#contact-form #submit-button {
    width: 100px;
    background-color:#333;
    color:#FFF;
    border:none;
    display:block;
    float:right;
    margin-bottom:0px;
    margin-right:6px;
    background-color:#8FB5C1;
    -moz-border-radius:8px;
}
 
#contact-form #submit-button:hover {
    background-color: #A6CFDD;
}
 
#contact-form #submit-button:active {
    position:relative;
    top:1px;
}

#success {
    border:solid 1px #83D186;
    padding:25px 10px;
    margin:25px 0px;
    display:block;
    width:700px;
    -webkit-border-radius:8px;
    -moz-border-radius:8px;
    border-radius:8px;
    <!--
    background:#D3EDD3 url(../img/accepted_48.png) no-repeat 405px center;
    -->
    font-weight:bold;
    display:block;
}
</style>
</head>

<body>
<div id="contact-form" class="clearfix">
	<h2>Spring's form tags example</h2>
	<p id="success" 
		<c:if test="${empty msg}">style="display:none;"</c:if>
	>${msg}</p>

	<form:form method="POST" modelAttribute="customer">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>UserName :</td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:textarea path="address" /></td>
				<td><form:errors path="address" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Confirm Password :</td>
				<td><form:password path="confirmPassword" /></td>
				<td><form:errors path="confirmPassword" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Subscribe to newsletter? :</td>
				<td><form:checkbox path="receiveNewsletter" /></td>
				<td><form:errors path="receiveNewsletter" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Favourite Web Frameworks :</td>
				<td><form:checkboxes items="${webFrameworkList}" path="favFramework" /></td>
				<td><form:errors path="favFramework" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Sex :</td>
				<td><form:radiobutton path="sex" value="M" />Male <form:radiobutton path="sex" value="F" />Female</td>
				<td><form:errors path="sex" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Choose a number :</td>
				<td><form:radiobuttons path="favNumber" items="${numberList}" /></td>
				<td><form:errors path="favNumber" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Country :</td>
				<td>
					<form:select path="country">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${countryList}" />
					</form:select>
				</td>
				<td><form:errors path="country" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Java Skills :</td>
				<td><form:select path="javaSkills" items="${javaSkillsList}" multiple="true" /></td>
				<td><form:errors path="javaSkills" cssClass="error" /></td>
			</tr>
			<form:hidden path="secretValue" />
			<tr>
				<td colspan="3"><input type="submit" id="submit-button" /></td>
			</tr>
		</table>
	</form:form>
</div>
</body>
</html>