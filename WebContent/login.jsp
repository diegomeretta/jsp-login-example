<html>
<%@page import="com.meretta.LoginController"%>  
<jsp:useBean id="obj" class="com.meretta.UsuarioDto"/>  
  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
	boolean status=LoginController.validate(obj);  
	if(status){  
		out.println("You r successfully logged in");  
		session.setAttribute("session","TRUE");  
	} else {  
		out.print("Sorry, email or password error");  
		%>  
		<jsp:include page="index.jsp"></jsp:include>  
		<%
	}  
%>
</html>