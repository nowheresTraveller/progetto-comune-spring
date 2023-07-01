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

	<form:form method="POST" action="doRegistration" modelAttribute="nuovoDipendente">
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
		   	<a href="/progetto-login/loginDipendente">
               	<input  type="button" value="indietro" />
            </a>
			<input type="submit" name="registrati"/>
		</div>
	</form:form>




</body>
</html>