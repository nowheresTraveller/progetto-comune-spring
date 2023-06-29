<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <link href="<c:url value="/static/css/home.css" />" rel="stylesheet">
</head>

<body>

	<h1>Comune di Casapulla</h1>
	
	 <a href="/progetto-login/loginDipendente">
        		<input  id="login_dipendente" type="button" value="login dipendente" />
     </a>
		 

	<h3>Inserimento dati anagrafici </h1>
		<br><br><br>

	<form:form method="POST" action="inserisciCittadino" modelAttribute="cittadino">

		<div>
			<form:label path="nome">nome</form:label>
			<form:input type="text" path="nome" required="required"/>

			<form:label path="cognome">cognome</form:label>
			<form:input type="text" path="cognome" required="required"/>
		</div>
		<div>
			<form:label path="data_di_nascita">data di nascita</form:label>
            <form:input type="text" path="dataNascita" required="required"/>

			<form:label path="codice_fiscale">codice fiscale</form:label>
			<form:input type="text" path="codiceFiscale" required="required"/>
		</div>
		<div>
			<input type="submit" name="inserisci"/>
		</div>
	</form:form>
</body>


</html>