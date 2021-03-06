<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="br.com.tio.mesindex.mes_index, java.text.SimpleDateFormat, java.util.Date"%>
<%@include file ="valida.jsp" %>
<%@include file="httpservletrequest.jsp"%>

<%
			String tperf="";
			String sqlperfil="select * from perfis where COD_PERFIL = '"+session.getAttribute("cod_perf")+"'";
			try{
				resultset =  statement.executeQuery(sqlperfil);
				while (resultset.next()){
					tperf= resultset.getString("NOME_PERF");
				}
			}
			catch(Exception e){
				System.out.println("Erro : "+ e);
			}
			try {
				 	String sqlnome = "select NOME_ABREV_USUARIO, COD_USUARIO, SENHA_USUARIO from usuarios where COD_USUARIO = '"+requisita("numbermat")+
						  		 	 "' and SENHA_USUARIO  = '"+requisita("password")+"'";
					resultset =  statement.executeQuery(sqlnome);					
					
				} 
		
		    catch(Exception e) {
				System.out.println("Erro : "+ e);
			}
%>

<%
	//Try Catch de Valida��o de Senha e Login.
	if (requisita("index.jsp")!=null)
	{
		try {
			session.removeAttribute("login");
			session.removeAttribute("cod_perf");
		    } 
		
	    catch(Exception e) {
							System.out.println("Erro : "+ e);
						   }
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
    <title>SFOC - Controle de acesso empres�rial</title>

    <meta name="description" content="Sistema de controle de acesso empresarial, utilizando da web como ambiente para a aplicação" />
    <meta name="author" content="Fabiano de Lima" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="SKYPE_TOOLBAR" content="SKYPE_TOOLBAR_PARSER_COMPATIBLE" />

	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,300' rel='stylesheet' type='text/css'>
    <link href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" rel="stylesheet">
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

    <style type="text/css">
        @media print{
            .notprint{display: none}
            .imprimir{display: block}
        }
    </style>
</head>
<body>
	<div id="wrap" class="hide">
        <header class="notprint">
            <div class="holder">
                <a href="#" class="logo"></a>
                <p id="current-date">
                    S�o Paulo, <%=mostra_data%> de <%=MesIndex.Mes_Index()%> de <%=ano_atual%>.<br>
                </p>
                <div class="user-box">
                    <span class="user-icon s-quart"></span><span class="user-name"><%while (resultset.next()){%><%=resultset.getString("NOME_ABREV_USUARIO")%><%}%></span>
                    <br/>
                    <a href="#logout" class="s-quart logout"></a>
                </div>
            </div>
        </header>
        <nav class="notprint">
            <ul class="holder">
                <li class="dropdown">
                    <a id="gerais" role="button" data-toggle="dropdown" href="#">Gerais <b class="caret"></b></a>
                    <ul id="menu1" class="dropdown-menu" role="menu" aria-labelledby="drop4">
                      <li role="presentation" class="perfis"><a role="menuitem" tabindex="-1" href="#Perfis/list">Perfil</a></li>
                      <li role="presentation" class="departamentos"><a role="menuitem" tabindex="-1" href="#Departamentos/list">Departamento</a></li>
                      <li role="presentation" class="feriados"><a role="menuitem" tabindex="-1" href="#Feriados/list">Feriados</a></li>
                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#Usuarios/list">Usu�rios</a></li>
                      <li role="presentation" class="operadores"><a role="menuitem" tabindex="-1" href="#Operadores/list">Operadores</a></li>
                      <li role="presentation" class="empresas"><a role="menuitem" tabindex="-1" href="#Empresas/list">Empresas</a></li>
                    </ul>
                  </li>
                  <li class="dropdown">
                    <a id="acesso" role="button" data-toggle="dropdown" href="#">Acesso <b class="caret"></b></a>
                    <ul id="menu1" class="dropdown-menu" role="menu" aria-labelledby="drop4">
                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#Faixas_Acesso/list">Faixas de Acesso</a></li>
                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#Zonas_Tempo/list">Zonas de Acesso</a></li>
                    </ul>
                  </li>
                  <li class="dropdown">
                    <a id="visitantes" role="button" data-toggle="dropdown" href="#">Visitantes <b class="caret"></b></a>
                    <ul id="menu1" class="dropdown-menu" role="menu" aria-labelledby="drop4">
                      <!--<li role="presentation"><a role="menuitem" tabindex="-1" href="#Status/list">Status </a></li>
                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#Especiais/list">Especial</a></li>-->
                      <li role="presentation"><a role="menuitem" tabindex="-1" href="#Visitantes/list">Controle de Visitantes</a></li>
                    </ul>
                  </li>
            </ul>
        </nav>
        <div id="container" class="imprimir">
            <div class="content holder">
                
            </div>
        </div>
        
        <footer class="notprint">
            <p>Copyright 2014 - Software of control - Todos os direitos reservados</p>
        </footer>  
         <div id="modal">
            <div class="modal-content">
                <a href="#close" class="button s-third bclose"></a>
                <div class="modal-text"><!-- add class to error: warning-->
                    <span class="big-icon"></span>
                    <div class="aviso">
                        <h2>Fabiano de Lima</h2>
                        <p>dsioahdasohas diosahodsa udshsdauidskahdsh dshoasdh ldas</p>
                    </div>
                    <div class="dialog hide">
                        <a href="#yes" class="yes">Sim</a>
                        <a href="#no" class="no">N�o</a>
                    </div>
                </div>
            </div>
        </div> 
    </div>
    <div class="mask">
        <img src="images/loader.gif" class="loader">
    </div>
    <input type="hidden" name="tperfil" value="<%=tperf%>" id="tperfil"/>
        <script src="js/lib/jquery.min.js"></script>
        <script src="js/lib/spine/min.js"></script>
        <script data-main="js/app" src="js/lib/require-jquery.js"></script>
        <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
    <!--<![endif]-->
</body>
</html>