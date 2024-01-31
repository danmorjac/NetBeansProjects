<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <jsp:useBean id="Cliente" scope="request" class="Entidad.Cliente" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Datos del cliente</h2>
        DNI: <jsp:getProperty name="Cliente" property="DNI" /> <br>
        NOMBRE: <jsp:getProperty name="Cliente" property="nombre" /> <br>
        PRIMER APELLIDO:<jsp:getProperty name="Cliente" property="apellido1" /> <br>
        SEGUNDO APELLIDO:<jsp:getProperty name="Cliente" property="apellido2" /> <br>
        NICK:<jsp:getProperty name="Cliente" property="nick" /> <br>
        
        PASSWORD:<jsp:getProperty name="Cliente" property="password" /> <br>
        ES DEUDOR:<jsp:getProperty name="Cliente" property="moroso" /> <br>
        SALDO:<jsp:getProperty name="Cliente" property="saldo" /> <br>
    </body>
</html>
