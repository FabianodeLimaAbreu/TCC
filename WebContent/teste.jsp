<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="mvc">

	Visitante: <input type="text" name="visitante">
	QTD: <input type="text" name="qtd">
	<input type="hidden" name="logica" value="AdicionaLogic">
	<input type="hidden" name="table" value="VisitantesAux">
	<input type="submit" value="Enviar">

</form>

</body>
</html>