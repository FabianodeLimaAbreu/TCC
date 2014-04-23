<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
    Remove this if you use the .htaccess -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>SFOC - Controle de acesso empresárial</title>

    <meta name="description" content="Sistema de controle de acesso empresarial, utilizando da web como ambiente para a aplicação" />
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
<body>
	<div id="wrap">
        <header>
            
        </header>
        <nav>
            <ul>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </nav>
        <div id="container">
            
        </div>
        <footer>
            <p>Copyright © 2014 - Software Of ContrOl - Todos os direitos reservados</p>
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
                            <a href="home.jsp">Sim</a>
                            <a href="#no">Não</a>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </div>
    <!--[if !IE]>-->
        <script src="js/lib/jquery.min.js"></script>
        <script src="js/lib/spine/min.js"></script>
        <script data-main="js/app" src="js/lib/require-jquery.js"></script>
    <!--<![endif]-->
</body>
</html>