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
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>New Dojo</h1>
		<form:form method="POST" action="/dojos/new" modelAttribute="dojoObj">
			<p>
				Name:
				<form:input type="text" path="name" />
				<form:errors path="name" />
			</p>
			<button>Create</button>
		</form:form>
	</div>
</body>
</html>