<%@page import="javax.swing.JOptionPane"%>
<%@page import="org.springframework.jdbc.datasource.DriverManagerDataSource"%>
<%@page import="org.apache.tomcat.dbcp.dbcp.DriverManagerConnectionFactory"%>
<%@page import="org.hibernate.service.jdbc.connections.internal.DriverManagerConnectionProviderImpl"%>
<%@page import="com.mysql.*"%>
<%@page import="java.sql.*"%>

<%!   
	Connection connection=null;
	Statement statement=null;
	ResultSet resultset=null;
	String acesso;
	String ordenacao;
	String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/db_sfoc";
    String usuario = "root";
    String senha   = ""; //crla010773
    
	public void jspInit() {
		try {
			Class.forName(driver);	
			connection = DriverManager.getConnection(url, usuario, senha);
			statement = connection.createStatement();
			//JOptionPane.showMessageDialog(null,"Passou pelo Statement");
		}
		
		catch (Exception e) {
			System.out.println("Falha na conexao: "+ e);		
		  }
	}
	
	public void jspDestroy() {
		try {
			statement.close();
			connection.close();
			//JOptionPane.showMessageDialog(null,"Conexão Fechada");
			
		} catch(Exception e) {
			System.out.println("Nao conseguiu fechar : "+e);
		}
		
	}    
%>

<%	
	acesso = (String) session.getAttribute("login");
%>