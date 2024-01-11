<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="myBean" scope="request" class="Entitats.LLoguerBean" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      </head>
    <body bgcolor="#ffffce">
        <%@ include file="navbar.html" %>
        <font  color="#9c9a00" size="6" >Informació del LLoguer</font><BR>
        <BR><B>NOM</B>: <jsp:getProperty name="myBean" property="nom" />        
        <BR><B>DIES</B>: <jsp:getProperty name="myBean" property="dies" />
        <BR><B>EDAT</B>: <jsp:getProperty name="myBean" property="edat" />
        <BR><B>FORMA DE PAGAMENT</B>: <jsp:getProperty name="myBean" property="pagament" />
        <BR><B>ESPECIFICACIONS</B>: <jsp:getProperty name="myBean" property="especificacions" />
        
        
    </body>
</html>

