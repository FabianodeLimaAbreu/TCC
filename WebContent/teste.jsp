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

	<input type="text" name="rg" id="rg" value="43.616.004-2">
	<input type="hidden" name="logica" id="logica" value="BuscarLogic">
	<input type="hidden" name="table" id="table" value="Visitantes">
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
            rg=$("#rg").val();
        	//Chamando o serviÃ§o para cadastro do usuario
            $.get("./mvc",{'logica':logica,'table':table,'rg':rg})
            .error(function(){
            	alert("Não foi possivel cadastrar o usuario");
            })
            .success(function(a){
            	alert("Hum");
            	console.dir(a);
                /*var objeto={
                    'nome':'Fabiano',
                    'idade':18
                };*/
                var teste=a;
                b(teste);
            });
        })();
        
        function b(a){
        	alert(a);
        }
	</script>
</body>
</html>