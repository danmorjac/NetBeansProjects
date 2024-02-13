package BLL;

import DAO.ClienteDAO;
import DAO.Conexion_DB;
import Entidad.Cliente;
import Entidad.Exceptions.ProgException;
import java.sql.Connection;
import java.util.List;

public class ClienteBLL {
  // Instanciar objetos
  private final Conexion_DB CON_DB = new Conexion_DB();
  private final ClienteDAO CLI_DAO = new ClienteDAO();
 
  public List<Cliente> findAll() throws Exception {
    // Abrimos la conexión
    Connection _con = CON_DB.abrirConexion();

    // Recuperamos los articulos
    List<Cliente> _listado = CLI_DAO.findAll(_con);

    // Cerramos la conexión
    CON_DB.closeWithCommit();

    return _listado;
  }

  public Cliente findByDNI(int DNI) throws Exception {
    try {
      // Abrimos la conexión
      Connection con = CON_DB.abrirConexion();

      // Recuperamos los articulos
      Cliente cli = CLI_DAO.findByDNI(con, DNI);

      // Cerramos la conexión
      CON_DB.closeWithCommit();

      return cli;
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw new ProgException("Usuario no encontrado");
    }
  }

  public Cliente findByElement(
    Cliente cliToSearch,
    String element
  ) throws Exception {
    // Abrimos la conexión
    Connection _con = CON_DB.abrirConexion();

    // Recuperamos los articulos
    Cliente cli = CLI_DAO.findByElement(_con, cliToSearch, element);

    // Cerramos la conexión
    CON_DB.closeWithCommit();

    return cli;
  }

  public Cliente validateCliente(String Nick, String Passwd) throws Exception {
    try {
      // Abrimos la conexión
      Connection _con = CON_DB.abrirConexion();

      // Recuperamos los articulos
      Cliente cli = CLI_DAO.validateCliente(_con, Nick, Passwd);

      // Cerramos la conexión
      CON_DB.closeWithCommit();

      return cli;
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw new ProgException("Usuario o clave incorrectas");
    }
  }
  
  public Cliente insertCliente(
    int DNI,
    String Nombre,
    String Apellido1,
    String Apellido2,
    String Nick,
    String Password,
    float saldo,
    boolean moroso
  ) throws Exception {
    try {
      // Abrimos la conexión
      Connection _con = CON_DB.abrirConexion();

      // Insertar el cliente
      Cliente newCli = CLI_DAO.insertCliente(
        _con, DNI, Nombre, Apellido1, Apellido2, Nick, Password, saldo, moroso
      );

      // Cerramos la conexión
      CON_DB.closeWithCommit();

      return newCli;
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw new ProgException("No se ha podido insertar el cliente");
    }
  }

  public void updateElementByDNI(Cliente cli, String element) throws Exception {
    try {
      // Abrimos la conexión
      Connection _con = CON_DB.abrirConexion();

      // Actualizar 1 elemento del cliente
      CLI_DAO.updateElementByDNI(_con, cli, element);

      // Cerramos la conexión
      CON_DB.closeWithCommit();
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }

  public void updateCliente(Cliente cli) throws Exception {
    try {
      // Abrimos la conexión
      Connection _con = CON_DB.abrirConexion();

      // Actualizar 1 elemento del cliente
      CLI_DAO.updateCliente(_con, cli);

      // Cerramos la conexión
      CON_DB.closeWithCommit();
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw new ProgException("No se ha podido actualizar el cliente");
    }
  }
  
  public void deleteClienteByDNI(Cliente cli) throws Exception {
    try {
      // Abrimos la conexión
      Connection _con = CON_DB.abrirConexion();

      // Actualizar 1 elemento del cliente
      CLI_DAO.deleteClienteByDNI(_con, cli);

      // Cerramos la conexión
      CON_DB.closeWithCommit();
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }
  
  public void deleteClienteByDNI(int DNI) throws Exception {
    try {
      // Abrimos la conexión
      Connection _con = CON_DB.abrirConexion();

      // Actualizar 1 elemento del cliente
      CLI_DAO.deleteClienteByDNI(_con, DNI);

      // Cerramos la conexión
      CON_DB.closeWithCommit();
    } catch (Exception e) {
      CON_DB.closeWithRollback();
      throw e;
    }
  }
}
