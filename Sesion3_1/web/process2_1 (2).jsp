<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="usuario" scope="request" class="Entidad.InfoUsuario" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% if (request.getParameter("name")==null
                && request.getParameter("email")== null) { %>
                Complete este formulario
                <form method="POST" action="process2_1.jsp">
                    Su nombre: <input type="text" name="name" size=26><BR>
                    Su email: <input type="text" name="email" size=26><BR>
                    <input type="submit" value="Enviar">
                </form>
        <% } else { %> <%-- scriptlet JSP --%>
                <% String nombre, mail; %> 
                <%
                nombre = request.getParameter("name");
                mail = request.getParameter("email");
                %>
                <jsp:setProperty name="usuario" property="name" value="<%=nombre%>" />
                <jsp:setProperty name="usuario" property="email" value="<%=mail%>" />
                <jsp:forward page="/process2_2.jsp" ></jsp:forward>          
                 <% } %>  
    </body>
</html>

