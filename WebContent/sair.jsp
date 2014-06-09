<%    
	try {
		
		session.removeAttribute("login");
	}
    
    catch (Exception e){}
%>
	<jsp:forward page="login.jsp" />
