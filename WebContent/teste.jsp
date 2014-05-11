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

	Validade: <input type="text" name="val_cartao" ><br/>
	Versao: <input type="text" name="versao"><br/>
	Cracha: <input type="text" name="cracha"><br/>
	Cod Emp: <input type="text" name="cod_emp"><br/>
	Nome Usuario: <input type="text" name="nome"><br/>
	Nome Abrev: <input type="text" name="nome_abrev"><br/>
	Cod tip: <input type="text" name="cod_tip"><br/>
	Senha: <input type="text" name="senha" ><br/>
		
	<input type="hidden" name="logica" value="AdicionarLogic">
	<input type="hidden" name="table" value="Contatos">
	<input type="submit" value="Enviar">
</form>

</body>
</html>