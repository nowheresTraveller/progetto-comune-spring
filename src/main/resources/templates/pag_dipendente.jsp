<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<html>
<head>

</head>
<body>

	<h1>Comune di Casapulla</h1>

	 <a href="/progetto-login/home">
        		<input  id="logout_button" type="button" value="logout" />
     </a>


	<table style="border: 1px solid black">
		<tr style="border: 1px solid black">
			<th>Nome</th>
			<th>Cognome</th>
			<th>Data di nascita</th>
			<th>Codice fiscale</th>
		</tr>
		<c:forEach items="${cittadini}" var="singoloCittadino">
		<tr style="border: 1px solid black">
			<td>${singoloCittadino.nome}</td>
			<td>${singoloCittadino.cognome}</td>
			<td>${singoloCittadino.dataNascita}</td>
			<td>${singoloCittadino.codiceFiscale}</td>
			<td>
				  <form:form method="POST" action="modificaCittadino" modelAttribute="singoloCittadino">
        			<input type="submit" name="modifica"/>
       		      </form:form>
			</td>
			<td>
				 <form:form method="POST" action="cancellaCittadino" modelAttribute="singoloCittadino">
        			<input type="submit" name="cancella"/>
       		      </form:form>
			</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>