<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Contenido dinámico mediante Scripts JSP:
        <UL>
          <LI><B>Expresiones JSP</B><BR>
                Fecha actual: <%= new Date() %>  </LI>
          <LI><B>Scriptlet JSP</B><BR>
              <% Calendar cal = Calendar.getInstance();
                 out.println("La fecha actual es: " +
                             cal.get(Calendar.DATE)+" /"+ 
                            (cal.get(Calendar.MONTH)+1) + " / "+ cal.get(Calendar.YEAR)); 
               %></LI>
          <LI><B>Declaración (más expresión).</B><BR>
              <%! private int accessCount = 0; %>
              Accesos a la página: 
              <%= ++accessCount %></LI>
        </UL>
    </body>
</html>
