<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/static/css/pag_dipendente_mod_citt.css" />" rel="stylesheet">
</head>

<body>

   <h1>Modifica dati cittadino</h1>

	<form:form method="POST" action="modificaCittadino" modelAttribute="singoloCittadino">
		<div>
			<form:label path="nome">nome</form:label>
			<form:input type="text" path="nome" required="required" value="${singoloCittadino.nome}"/>
		</div>
		<div>
			<form:label path="cognome">cognome</form:label>
			<form:input type="text" path="cognome" required="required" value="${singoloCittadino.cognome}"/>
		</div>
		<div>
			<form:label path="codice fiscale">codice fiscale</form:label>
			<form:input type="text" path="codiceFiscale" required="required" value="${singoloCittadino.codiceFiscale}"/>
		</div>
		<div>
			<form:label path="data di nascita">data di nascita</form:label>
			<form:input type="text" path="dataNascita" required="required" value="${singoloCittadino.dataNascita}"/>
		</div>
		<div>
			<a href="/progetto-login/pagDipendente">
                           	<input  type="button" value="indietro" />
            </a>
			<input type="submit" name="modifica"/>

		</div>
	</form:form>




</body>
</html>