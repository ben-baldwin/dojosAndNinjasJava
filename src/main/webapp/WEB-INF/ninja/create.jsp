<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>
<h1>New Ninja</h1>
	<form:form method="POST" action="/ninjas/new" modelAttribute="ninjaObj">
		<p>
			Dojo:
			<form:select path="school">
				<c:forEach var="dojo" items="${allDojos}">
					<form:option value="${dojo.id}">
						<c:out value="${dojo.name}" />
					</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			First Name:
			<form:input type="text" path="firstName" />
			<form:errors path="firstName" />
		</p>
		<p>
			Last Name:
			<form:input type="text" path="lastName" />
			<form:errors path="lastName" />
		</p>
		<p>
			Age:
			<form:input type="number" path="age" />
			<form:errors path="age" />
		</p>
		<button>Create</button>
	</form:form>
</body>
</html>