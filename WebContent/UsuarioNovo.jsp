<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>

	<form role="form" action="">
       <div class="form-group">
         <label for="nome">Nome</label>
         <input type="text" class="form-control" name="nome" placeholder="Nome completo:">
       </div>
       <div class="form-group">
         <label for="email">Email</label>
         <input type="email" class="form-control" name="email" placeholder="Email">
       </div>
       <input type="submit" class="btn btn-default bsubmit">
     </form>
     
     <input type="hidden" name="logica" value="AdicionaUsuarioLogic" id="logica">

	<script src="js/lib/jquery.min.js"></script>
	<script type="text/javascript">
			var logica;
            var contato={
                //Padrao de objeto
                nome:"",
                email:"",
            };
            $(".bsubmit").bind("click",function(a){
                a.preventDefault();
                
                //Seta valores no objeto
                contato.nome=$("input[name='nome'").val();
                contato.email=$("input[name='email'").val();
                logica=$("#logica").val();

                //Chamando o serviÃ§o para cadastro do usuario
                $.get("./mvc",{'nome':contato.nome,'email':contato.email,'logica':logica})
                .error(function(){
                	alert("Não foi possivel cadastrar o usuario");
                })
                .success(function(){
                	alert("Usuario cadastrado com sucesso");
                });
            });
        </script>
</body>
</html>