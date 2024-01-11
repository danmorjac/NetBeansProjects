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
        <b>Usted indicó la siguiente información</b>:
        <BR><B>Nombre</B>: <jsp:getProperty name="usuario" property="name" />
        <BR><B>Email</B>: <jsp:getProperty name="usuario" property="email" />
        <BR><b>¡Esta respuesta ha sifo generado desde un JSP independizado 
        de la lógica de negocio que produjo el JavaBean que usa!</b>
    </body>
</html>

