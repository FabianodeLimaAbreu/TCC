<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="">

	Validade: <input type="text" name="val_cartao" ><br/>
	Versao: <input type="text" name="versao"><br/>
	Cracha: <input type="text" name="cracha"><br/>
	Cod Emp: <input type="text" name="cod_emp"><br/>
	Nome Usuario: <input type="text" name="nome"><br/>
	Nome Abrev: <input type="text" name="nome_abrev"><br/>
	Cod tip: <input type="text" name="cod_tip"><br/>
	Senha: <input type="text" name="senha" ><br/>
		
	<input type="hidden" name="logica" id="logica" value="BuscarLogic">
	<input type="hidden" name="table" id="table" value="Contatos">
	<input type="submit" value="Enviar" class="bsubmit">
</form>
<script src="js/lib/jquery.min.js"></script>
	<script type="text/javascript">
		var contato={
			nome:""
		};
		$(".bsubmit").bind("click",function(a){
			alert("ok");
            a.preventDefault();
            
            //Seta valores no objeto
            contato.nome=$("input[name='nome'").val();
            logica=$("#logica").val();
            table=$("#table").val();

            //Chamando o serviÃ§o para cadastro do usuario
            $.get("./mvc",{'nome':contato.nome,'logica':logica,'table':table})
            .error(function(){
            	alert("Não foi possivel cadastrar o usuario");
            })
            .success(function(){
            	alert("Usuario cadastrado com sucesso");
            });
        });
        (function(){
        	logica=$("#logica").val();
            table=$("#table").val();
        	//Chamando o serviÃ§o para cadastro do usuario
            $.get("./mvc",{'logica':logica,'table':table})
            .error(function(){
            	alert("Não foi possivel cadastrar o usuario");
            })
            .success(function(){
            	alert("Usuario cadastrado com sucesso");
            });
        })();
	</script>
</body>
</html>