<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd"> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body bgcolor="#ffffcc">
        <% if ((request.getParameter("name")==null
                && request.getParameter("email")== null)
                ||
                (request.getParameter("name").equals("")
                && request.getParameter("email").equals(""))
                ) 
                           { %>
                Complete este formulario
                <form method="POST" action="process.jsp">
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
                <b>Usted indicó la siguiente información</b>:
                <BR><B>Nombre</B>: <%= nombre %><%-- expresion JSP --%>
                <BR><B>Email</B>: <%= mail %>
        <% } %>            
    </body>
</html>
