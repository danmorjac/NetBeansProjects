<jsp:useBean id="Cliente" scope="request" class="Entidad.Cliente" />
<form action="Controller?opID=EditaCliente" method="POST">
    <h3>Editar Perfil de usuario:</h3>
    Nick:
    <input type="text" name="Nick" size="80" value='<jsp:getProperty name="Cliente" property="nick" />'  />
    <br>
    Password:
    <input type="password" name="Password" size="80" value='<jsp:getProperty name="Cliente" property="password" />'/>
    <br>
    Nombre:
    <input type="text" name="Nombre" size="80"  value='<jsp:getProperty name="Cliente" property="nombre" />'/>
    <br>
    Apellido 1:
    <input type="text" name="Apellido1" size="80" value='<jsp:getProperty name="Cliente" property="apellido1" />'/>
    <br>
    Apellido 2:
    <input type="text" name="Apellido2" size="80" value='<jsp:getProperty name="Cliente" property="apellido2" />'/>
    <br>
    <input type="submit" value="Entrar" />    
</form>

