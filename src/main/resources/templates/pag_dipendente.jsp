<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<c:forEach items="${cittadinoList}" var="singoloCittadino">
		<tr style="border: 1px solid black">
			<td>${singoloCittadino.nome}</td>
			<td>${singoloCittadino.cognome}</td>
			<td>${singoloCittadino.dataNascita}</td>
			<td>${singoloCittadino.codiceFiscale}</td>
			<td>
				  <form:form method="POST" action="modificaCittadino" modelAttribute="${singoloCittadino}">
        			<input type="submit" name="modifica" value="modifica"/>
       		      </form:form>
			</td>
			<td>
				 <form:form method="POST" action="cancellaCittadino" modelAttribute="${singoloCittadino}">
        			<input type ="submit" name="cancella" value="cancella"/>
       		      </form:form>

   			</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>