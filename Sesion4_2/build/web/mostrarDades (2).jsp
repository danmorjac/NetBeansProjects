<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="alumne" scope="request" class="Entitat.InfoAlumne" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Alumne ha introduït les sigüents dades:</h2><br>
        Nom: <jsp:getProperty name="alumne" property="nom" /> <br>
        Primer cognom: <jsp:getProperty name="alumne" property="primerCognom" /> <br>
        Segon cognom: <jsp:getProperty name="alumne" property="segonCognom" /> <br>
     </body>
</html>
