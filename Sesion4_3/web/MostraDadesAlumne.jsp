<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="alumne" scope="request" class="Entitats.AlumneBean" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <font  color="#9c9a00" size="6" >Informació de l'Alumne</font><BR>
        <BR><B>NOM</B>: <jsp:getProperty name="alumne" property="nom" />        
        <BR><B>PRIMER COGNOM</B>: <jsp:getProperty name="alumne" property="primerCognom" />
        <BR><B>SEGON COGNOM</B>: <jsp:getProperty name="alumne" property="segonCognom" />
        <BR><B>DNI</B>: <jsp:getProperty name="alumne" property="dni" />
        
        
    </body>
</html>
