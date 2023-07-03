<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <link href="<c:url value="/static/css/login_dipendente.css" />" rel="stylesheet">
</head>

<body>

    <h1>Login dipendendente</h1>

    <form:form method="POST" action="loginFunction" modelAttribute="dipendente">
        <div>
			<form:label path="username">username</form:label>
			<form:input type="text" path="username" required="required"/>

			<form:label path="password">password</form:label>
			<form:input type="password" path="password" required="required"/>
		</div>
		<div>
			<input type="submit" name="login" value="login"/>
            <a href="/progetto-comune/registrationPage">
        		<input  type="button" value="registrati" />
	        </a>
	    </div>
	</form:form>



</body>
</html>