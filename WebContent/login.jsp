<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="br.com.tio.mesindex.mes_index, java.text.SimpleDateFormat, java.util.Date, javax.swing.JOptionPane"%>
<%@include file="conexao.jsp" %>
<%@include file="httpservletrequest.jsp" %>

<%
	int cod_perf;
	//Try Catch de ValidaÁ„o de Senha e Login.
	if (requisita("valida")!=null)
	{
		try {
			String sqlacesso = "select LOGIN_OPERADOR, SENHA_OPERADOR, COD_PERF_OPERADOR from operadores where LOGIN_OPERADOR = '"+requisita("numbermat")+
			"' and SENHA_OPERADOR  = '"+requisita("password")+"'";
			resultset =  statement.executeQuery(sqlacesso);
											
			if (resultset.next()) {
				cod_perf=Integer.parseInt(resultset.getString("COD_PERF_OPERADOR"));
				session.setAttribute("cod_perf",cod_perf);
				session.setAttribute("login",resultset.getString("COD_PERF_OPERADOR"));
%>
				<jsp:forward page="index.jsp" />
<%
			     }
		    } 
		
	    catch(Exception e) {
							System.out.println("Erro : "+ e);
						   }
	 }

%>

<%
			try {
				 	String sqlnome = "select EMAIL_USUARIO, SENHA_USUARIO from usuarios where COD_USUARIO = '"+requisita("numbermat")+"'";
					resultset =  statement.executeQuery(sqlnome);					
					
				} 
		
		    catch(Exception e) {
			System.out.println("Erro : "+ e);
			}
%>

<%    
	Date data = new Date();
	SimpleDateFormat diatual = new SimpleDateFormat("dd");
	String mostra_data = diatual.format(data);

	mes_index MesIndex = new mes_index ();  

	Date ano = new Date();
	SimpleDateFormat anoatual = new SimpleDateFormat("yyyy");
	String ano_atual = anoatual.format(data);   
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
    Remove this if you use the .htaccess -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>SFOC - Controle de acesso empres√°rial</title>

    <meta name="description" content="Sistema de controle de acesso empresarial, utilizando da web como ambiente para a aplica√ß√£o" />
    <meta name="author" content="Fabiano de Lima" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="SKYPE_TOOLBAR" content="SKYPE_TOOLBAR_PARSER_COMPATIBLE" />

	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,300' rel='stylesheet' type='text/css'>
    <!-- build:css css/app.min.css-->
    <link rel="stylesheet" type="text/css" href="css/common.min.css" media="screen">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <!-- endbuild -->

	<!--Replace with the root of the domain-->
    <link rel="shortcut icon" href="favicon.ico" />
    <link rel="icon" type="image/icon" href="favicon.ico">
    <link rel="apple-touch-icon" href="apple-touch-ico.png" />

    <!--[if lt IE 9]>
	    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	    <link href="css/iehack.css" rel="stylesheet">
	<![endif]-->

    <!--[if IE]><script src="js/lib/jquery.min.js"></script><script src="js/lib/spine/min.js"></script><script data-main="js/app.js" src="js/lib/require-jquery.js"></script><![endif]-->

</head>
<body class="loginpage">
	<div id="wrap">
        <header>
            <div class="holder">
                <a href="" class="logo"></a>
                <p id="current-date">
                    S„o Paulo, <%=mostra_data%> de <%=MesIndex.Mes_Index()%> de <%=ano_atual%>.
                </p>
            </div>
        </header>
        <div id="container">
            <div class="content holder">
                <!--Logar-->

                <div class="box">
                    <form action="" role="form" class="loginform">
                        <!--Login-->
                        <tr><td colspan="2"><%= httpServletRequest.getParameter("valida") == null?"Informe seu Usu·rio e Senha":"Seus Dados S„o Invalidos"%></td></tr>
                        <div class="input-group first">
                          <span class="input-group-addon  ico numbermat"></span>
                          <input type="number" class="form-control" placeholder="N˙mero da matricula" name="numbermat" required>
                        </div>
                        <div class="input-group">
                          <span class="input-group-addon ico key"></span>
                          <input type="password" class="form-control passinput" name="password" placeholder="Senha" required>
                          <!--        <span class="input-group-addon submit"><a href="#submit" name="valida" class="signin"></a></span> -->
                                      <input type="submit" value="Acessar" name="valida">
                        </div>
                    </form>
                    <form action="" role="form" class="forgotform">
                        <!--esqueceu a senha-->
                        <div class="input-group">
                          <span class="input-group-addon  ico email"></span>
                          <input type="email" class="form-control" placeholder="Email" name="email" required>
                        </div>
                        <div class="input-group question-buttons">
                            <a href="#forgot" class="bquestion forgot">Continuar</a>
                            <a href="#back" class="bquestion back">Voltar</a>
                        </div>
                    </form>
                    <div class="arrow-down">
                        <span></span>
                    </div>
                    <p class="loginform">
                        <span>logar</span><a href="#forget" class="bforgot">esqueceu a senha?</a>
                    </p>
                    <p class="forgotform">
                        <span>Esqueci a senha</span><a href="#login" class="blogin">Logar</a>
                    </p>
                </div>

                <!--Esqueci a senha
                    
                <div class="box">
                    <form action="" role="form">
                        <div class="input-group">
                          <span class="input-group-addon  ico email"></span>
                          <input type="email" class="form-control" placeholder="Email" name="email" required>
                        </div>
                        <div class="input-group question-buttons">
                            <a href="#forgot" class="bquestion forgot">Continuar</a>
                            <a href="#back" class="bquestion back">Voltar</a>
                        </div>
                    </form>
                    <div class="arrow-down">
                        <span></span>
                    </div>
                    <p>
                        <span>Esqueci a senha</span><a href="#login">Logar</a>
                    </p>
                </div>-->

            </div>
        </div>
        <footer>
            <p>Copyright 2014 - Software of control - Todos os direitos reservados</p>
        </footer>  
        <div id="modal" class="hide">
            <div class="modal-content">
                <a href="#close" class="button s-third"></a>
                <div class="modal-text">
                    <span class="big-icon"></span>
                    <div class="aviso">
                        <h2></h2>
                        <p></p>
                        <div class="dialog">
                            <a href="#yes" class="yes">Sim</a>
                            <a href="#no" class="no">N„o</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>  
    </div>
    <!--[if !IE]>-->
        <script src="js/lib/jquery.min.js"></script>
        <script src="js/lib/spine/min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script data-main="js/login" src="js/lib/require-jquery.js"></script>   
    <!--<![endif]-->
</body>
</html>