<%!
	HttpServletRequest httpServletRequest;
	String requisita(String valor) {
		String temp = httpServletRequest.getParameter(valor);
		if (temp==null) 
			temp="";
		return temp;	
	}
%>

<%
	httpServletRequest = request;
%>