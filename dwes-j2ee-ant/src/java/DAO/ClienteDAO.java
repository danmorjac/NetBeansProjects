package DAO;

import Entidad.Cliente;
import Entidad.Factura;
import Entidad.Utilidad.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends AbstractDAO {

  private Cliente inicializarCliente() throws SQLException {
    return new Cliente(
      rs.getInt("DNI"),
      rs.getString("Nombre"),
      rs.getString("Ape1"),
      rs.getString("Ape2"),
      rs.getString("Nick"),
      rs.getString("Passwd"),
      rs.getFloat("Saldo"),
      rs.getInt("Moroso") == 1
    );
  }
  
  public ArrayList<Cliente> findAll(Connection con) throws Exception {
    try {
      stmt = con.prepareStatement("SELECT * FROM Cliente");
      rs = stmt.executeQuery();

      ArrayList<Cliente> listaClientes = new ArrayList();
      while (rs.next()) listaClientes.add(inicializarCliente());
      return listaClientes;
    } 
    catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al buscar los articulos "
        + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public Cliente findByDNI(
    Connection con, 
    int DNI
  ) throws Exception {
    try {
      stmt = con.prepareStatement("SELECT * FROM Cliente WHERE dni=?");
      stmt.setInt(1, DNI);
      rs = stmt.executeQuery();
      rs.next();

      return inicializarCliente();
    } 
    catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al buscar el cliente con DNI "
        + DNI
        + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public Cliente findByElement(
    Connection con,
    Cliente cliente,
    String element
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
        "SELECT * FROM Cliente WHERE "
        + element
        + "=?"
      );

      switch (element) {
        case "DNI":
          stmt.setInt(1, cliente.getDNI());
          break;
        case "Nombre":
          stmt.setString(1, cliente.getNombre());
          break;
        case "Ape1":
          stmt.setString(1, cliente.getApellido1());
          break;
        case "Ape2":
          stmt.setString(1, cliente.getApellido2());
          break;
        case "Nick":
          stmt.setString(1, cliente.getNick());
          break;
        case "Passwd":
          stmt.setString(1, cliente.getPassword());
          break;
        case "Saldo":
          stmt.setFloat(1, cliente.getSaldo());
          break;
        case "Moroso":
          stmt.setInt(1, cliente.isMoroso() ? 1 : 0);
          break;
        default:
          throw new Exception("Operacion no permitida");
      }
      rs = stmt.executeQuery();
      rs.next();

      return inicializarCliente();
    } 
    catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al buscar el articulos "
        + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public Cliente validateCliente(
    Connection con,
    String Nick,
    String Passwd
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
        "SELECT * FROM Cliente "
        + "WHERE Nick=? AND Passwd=?"
      );
      stmt.setString(1, Nick);
      stmt.setString(2, Passwd);
      rs = stmt.executeQuery();
      rs.next();

      return inicializarCliente();
    } 
    catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al validar el cliente "
        + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public Cliente insertCliente(
    Connection con,
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
      stmt = con.prepareStatement(
        "INSERT INTO cliente VALUES(?,?,?,?,?,?,?,?)"
      );
      stmt.setInt(1, DNI);
      stmt.setString(2, Nombre);
      stmt.setString(3, Apellido1);
      stmt.setString(4, Apellido2);
      stmt.setString(5, Nick);
      stmt.setString(6, Password);
      stmt.setFloat(7, saldo);
      stmt.setInt(8, moroso ? 1 : 0);
      stmt.executeUpdate();

      return new Cliente(
        DNI, Nombre, Apellido1, Apellido2, Nick, Password, saldo, moroso
      );
    } 
    catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al insertar el usuario "
        + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public void updateElementByDNI(
    Connection con,
    Cliente cli,
    String element
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
        "UPDATE cliente SET " + element + "=? WHERE DNI=?"
      );

      switch (element) {
        case "Nombre":
          stmt.setString(1, cli.getNombre());
          break;
        case "Ape1":
          stmt.setString(1, cli.getApellido1());
          break;
        case "Ape2":
          stmt.setString(1, cli.getApellido2());
          break;
        case "Nick":
          stmt.setString(1, cli.getNick());
          break;
        case "Passwd":
          stmt.setString(1, cli.getPassword());
          break;
        case "Saldo":
          stmt.setFloat(1, cli.getSaldo());
          break;
        case "Moroso":
          stmt.setInt(1, cli.getMoroso());
          break;
        default:
          throw new Exception("Operacion no permitida");
      }
      stmt.setInt(2, cli.getDNI());
      stmt.executeUpdate();
    } 
    catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al actualizar el elemento "
        + element
        + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }
  
  // Usado en:
  // - addArticuloFactura en BLL para actualizar la cantidad pedida
  public void updateSaldo(
    Connection con, int dni, float saldo, boolean isMoroso
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
        "UPDATE cliente "
        + "SET Saldo=?, Moroso=" + (isMoroso ? "1" : "0")
        + " WHERE DNI=?"
      );
      stmt.setFloat(1, saldo);
      stmt.setInt(2, dni);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al actualizar el cliente " + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public void updateCliente(
    Connection con,
    Cliente cli
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
        "UPDATE cliente "
        + "SET Nombre=?, Ape1=?, Ape2=?, Nick=?, Passwd=? "
        + "WHERE DNI=? limit 1"
      );
      stmt.setString(1, cli.getNombre());
      stmt.setString(2, cli.getApellido1());
      stmt.setString(3, cli.getApellido2());
      stmt.setString(4, cli.getNick());
      stmt.setString(5, cli.getPassword());
      stmt.setInt(6, cli.getDNI());

      stmt.executeUpdate();
    } 
    catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al actualizar el cliente " + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public void deleteClienteByDNI(Connection con, Cliente cli) throws Exception {
    try {
      stmt = con.prepareStatement("DELETE FROM cliente WHERE DNI=?");
      stmt.setInt(1, cli.getDNI());
      stmt.executeUpdate();
    } 
    catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al eliminar el cliente " + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public void deleteClienteByDNI(Connection con, int DNI) throws Exception {
    try {
      stmt = con.prepareStatement("DELETE FROM cliente WHERE DNI=?");
      stmt.setInt(1, DNI);
      stmt.executeUpdate();
    } 
    catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al eliminar el cliente " + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  // -> JESUS
  // Deberia estar en Facturas
  public Cliente getClienteFacturas(Connection con, Cliente cliente) throws Exception {
    ResultSet rs = null;
    PreparedStatement stmt = null;
    Cliente clientenuevo = new Cliente();
    try {
      stmt = con.prepareStatement("SELECT distinct(f.idFactura), f.Fecha FROM  factura f INNER JOIN articulo_factura a ON f.idFactura = a.Factura_idFactura WHERE f.Cliente_DNI=?");
      stmt.setInt(1, cliente.getDNI());
      rs = stmt.executeQuery();

      while (rs.next()) {
        Factura _factura = new Factura();
        _factura.setId(rs.getInt("idFactura"));
        _factura.setFecha(rs.getInt("Fecha"));
        clientenuevo.getFacturas().add(_factura);
      }
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception("Ha habido un problema al buscar el cliente por DNI " + ex.getMessage());
    } finally {
      if (rs != null) {
        rs.close(); //Cerramos el resulset
      }
      if (stmt != null) {
        stmt.close();//Cerramos el Statement 
      }
    }
    return clientenuevo;
  }

  // No implementado -> Se elimina solo por DNI de momento
  public void eliminaUsuario(Connection con, Cliente cliente) throws Exception {
    PreparedStatement stmt = null;
    try {
      stmt = con.prepareStatement("DELETE FROM cliente WHERE Nick=?");
      stmt.setString(1, cliente.getNick());
      stmt.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new Exception("Ha habido un problema al eliminar el Usuario " + ex.getMessage());
    } finally {
      if (stmt != null) {
        stmt.close();//Cerramos el Statement 
      }
    }
  }

}
