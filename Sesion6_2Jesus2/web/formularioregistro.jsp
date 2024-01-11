<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="Controller?opID=Registro" method="POST">
    Nick:
    <input type="text" name="Nick" size="80"  placeholder="Introduce tu nick" />
    <br>
    Password:
    <input type="password" name="Password" size="80" placeholder="Introduce tu password" />
    <br>
    Nombre:
    <input type="text" name="Nombre" size="80" placeholder="Introduce tu nombre" />
    <br>
    Apellido 1:
    <input type="text" name="Apellido1" size="80" placeholder="Introduce tu primer apellido" />
    <br>
    Apellido 2:
    <input type="text" name="Apellido2" size="80" placeholder="Introduce tu segundo apellido" />
    <br>
    DNI:
    <input type="number" name="DNI" size="80" placeholder="Introduce tu DNI sin letra" maxlength="8" />
    <br>
    SALDO:
    <input type="number" name="SALDO" size="80" placeholder="Saldo que vas a ingresar (€)" step="any"/>&nbsp;€
    <br>    
    <input type="submit" value="Entrar" />    
</form>
