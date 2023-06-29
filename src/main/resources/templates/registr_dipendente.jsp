<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/static/css/registr_dipendente.css" />" rel="stylesheet">
</head>

<body>

   <h1>Registrazione dipendente</h1>

	<form:form method="POST" action="doRegistration" modelAttribute="dipendenteDaRegistrare">
		<div>
			<form:label path="nome">nome</form:label>
			<form:input type="text" path="nome" required="required" />
		</div>
		<div>
			<form:label path="cognome">cognome</form:label>
			<form:input type="text" path="cognome" required="required"/>
		</div>
		<div>
			<form:label path="username">username</form:label>
			<form:input type="text" path="username" required="required"/>
		</div>
		<div>
			<form:label path="password">password</form:label>
			<form:input type="text" path="password" required="required"/>
		</div>
		<div>
			<input type="submit" name="registrati"/>
			<a href="/progetto-login/loginDip">
               	<input  type="button" value="indietro" />
            </a>
		</div>
	</form:form>




</body>
</html>