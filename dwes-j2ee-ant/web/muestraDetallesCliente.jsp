<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Cliente" scope="request" class="Entidad.Cliente" />
<section>
  <h2>Datos del cliente</h2>
  DNI: <jsp:getProperty name="Cliente" property="DNI" /> <br>
  NOMBRE: <jsp:getProperty name="Cliente" property="nombre" /> <br>
  PRIMER APELLIDO:<jsp:getProperty name="Cliente" property="apellido1" /> <br>
  SEGUNDO APELLIDO:<jsp:getProperty name="Cliente" property="apellido2" /> <br>
  NICK:<jsp:getProperty name="Cliente" property="nick" /> <br>

  PASSWORD:<jsp:getProperty name="Cliente" property="password" /> <br>
  ES DEUDOR:<jsp:getProperty name="Cliente" property="moroso" /> <br>
  SALDO:<jsp:getProperty name="Cliente" property="saldo" /> <br>
</section>
