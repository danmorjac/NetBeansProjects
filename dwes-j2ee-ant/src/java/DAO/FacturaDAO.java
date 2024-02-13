package DAO;

import Entidad.Articulo;
import Entidad.Cliente;
import Entidad.Factura;
import Entidad.Utilidad.Log;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FacturaDAO extends AbstractDAO {

  private Factura initFactura() throws SQLException {
    return new Factura(rs.getInt("idFactura"), rs.getInt("Fecha"));
  }

  private Articulo initArticuloDeFactura() throws SQLException {
    return new Articulo(
      rs.getInt("Articulo_idArticulo"),
      rs.getString("Descripcion"),
      rs.getInt("Numero"),
      rs.getFloat("Precio")
    );
  }

  private ArrayList<Factura> initFacturasWithArticulos() throws SQLException {
    ArrayList<Factura> listaFacturas = new ArrayList();
    
    while (rs.next()) {
      boolean createFCT = true;

      for (Factura factura : listaFacturas) {
        if (factura.getId() == rs.getInt("idFactura")) {
          factura.getArticulos().add(this.initArticuloDeFactura());
          createFCT = false;
          break;
        }
      }

      if (createFCT) {
        Factura fct = initFactura();
        fct.getArticulos().add(this.initArticuloDeFactura());
        listaFacturas.add(fct);
      }
    }

    return listaFacturas;
  }

  public ArrayList<Factura> findLess(Connection connection) throws Exception {
    try {
      stmt = connection.prepareStatement("SELECT * FROM Factura");
      rs = stmt.executeQuery();

      ArrayList<Factura> listaFacturas = new ArrayList();
      while (rs.next()) {
        listaFacturas.add(initFactura());
      }
      return listaFacturas;
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al buscar las facturas "
        + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public ArrayList<Factura> findLessByClienteDNI(
    Connection connection,
    int DNI
  ) throws Exception {
    try {
      stmt = connection.prepareStatement(
        "SELECT * FROM Factura "
        + "WHERE cliente_dni=? "
        + "order by idFactura desc"
      );
      stmt.setInt(1, DNI);
      rs = stmt.executeQuery();

      ArrayList<Factura> listaFacturas = new ArrayList();
      while (rs.next()) {
        listaFacturas.add(initFactura());
      }
      return listaFacturas;
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al buscar las facturas del cliente con DNI "
        + DNI
        + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public ArrayList<Factura> findAll(
    Connection connection
  ) throws Exception {
    try {
      stmt = connection.prepareStatement(findAllQuery());
      rs = stmt.executeQuery();

      return initFacturasWithArticulos();
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al buscar las facturas "
        + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }
  
  public ArrayList<Factura> findAllByClienteDNI(
    Connection connection,
    int DNI
  ) throws Exception {
    try {
      stmt = connection.prepareStatement(
        findAllQuery() + "WHERE Factura.Cliente_DNI=?;"
      );
      stmt.setInt(1, DNI);
      rs = stmt.executeQuery();

      return initFacturasWithArticulos();
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al buscar las facturas "
        + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }
  
  private String findAllQuery() {
    return "SELECT "
      + "Factura.idFactura, "
      + "Factura.Fecha, "
      + "Articulo_Factura.Articulo_idArticulo, "
      + "Articulo.Descripcion, "
      + "Articulo_Factura.Numero "
      + "Articulo.Precio "
      + "FROM Factura "
      + "JOIN Articulo_Factura "
      + "ON Factura.idFactura = Articulo_Factura.Factura_idFactura "
      + "JOIN Articulo "
      + "ON Articulo_Factura.Articulo_idArticulo = Articulo.idArticulo ";
  }

  public Factura findLessById(
    Connection connection,
    int idFactura
  ) throws Exception {
    try {
      stmt = connection.prepareStatement(
        "SELECT * FROM Factura "
        + "WHERE idFactura=?"
      );
      stmt.setInt(1, idFactura);
      rs = stmt.executeQuery();
      rs.next();

      return initFactura();
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
        "Ha habido un problema al buscar la factura con id "
        + idFactura
        + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public Factura insertFactura(
    Connection con,
    int fecha,
    int DNI
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
        "INSERT INTO FACTURA(Fecha,Cliente_DNI) VALUES(?,?)",
        Statement.RETURN_GENERATED_KEYS
      );
      stmt.setInt(1, fecha);
      stmt.setInt(2, DNI);
      stmt.executeUpdate();
      rs = stmt.getGeneratedKeys();
      rs.next();
      int idFactura = rs.getInt(1);

      return new Factura(idFactura, fecha);
    } catch (SQLException e) {
      Log.getInstance().error(e);
      throw new Exception(
        "Ha habido un problema al crear la factura para el cliente con DNI "
        + DNI
        + e.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public void deleteById(
    Connection con,
    int idFactura
  ) throws Exception {
    try {
      stmt = con.prepareStatement("DELETE FROM factura WHERE idFactura=?");
      stmt.setInt(1, idFactura);
      stmt.executeUpdate();
    } catch (Exception e) {
      Log.getInstance().error(e);
      throw new Exception(
        "Ha habido un problema al borrar la factura con id "
        + idFactura
        + e.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public void getArticulosFactura(
    Connection con,
    Factura factura
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
        "SELECT Articulo_idArticulo, Numero, Descripcion, Precio "
        + "FROM  articulo_factura af,articulo a "
        + "WHERE af.Articulo_idArticulo=a.idArticulo AND af.Factura_idFactura=?"
      );
      stmt.setInt(1, factura.getId());
      rs = stmt.executeQuery();

      while (rs.next()) {
        factura.getArticulos().add(this.initArticuloDeFactura());
      }
    } catch (SQLException e) {
      Log.getInstance().error(e);
      throw new Exception(
        "Ha habido un problema al solicitar los articulos de la factura "
        + e.getMessage()
      );
    } finally {
      this.clean();
    }
  }
  
  public int getPropietarioFactura(
    Connection con, int idFactura
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
        "SELECT C.DNI FROM Cliente C "
          + "JOIN Factura F ON C.DNI = F.Cliente_DNI "
          + "JOIN Articulo_Factura AF ON F.idFactura = AF.Factura_idFactura "
          + "WHERE AF.Factura_idFactura=?; "
      );
      stmt.setInt(1, idFactura);
      rs = stmt.executeQuery();
      rs.next();
      return rs.getInt("DNI");
    } catch (SQLException e) {
      Log.getInstance().error(e);
      throw new Exception(
        "Ha habido un problema al solicitar el propietario de la factura "
        + e.getMessage()
      );
    } finally {
      this.clean();
    }
  }
  
  public float getTotal(Connection con, int idFactura) throws Exception {
    try {
      stmt = con.prepareStatement(
        "SELECT SUM(A.Precio * AF.Numero) AS SumatorioPrecios "
          + "FROM Articulo A "
          + "JOIN Articulo_Factura AF "
          + "ON A.idArticulo = AF.Articulo_idArticulo "
          + "WHERE AF.Factura_idFactura=?; "
      );
      stmt.setInt(1, idFactura);
      rs = stmt.executeQuery();
      rs.next();
      return rs.getFloat("SumatorioPrecios");
    } catch (SQLException e) {
      Log.getInstance().error(e);
      throw new Exception(
        "Ha habido un problema al solicitar el total de la factura "
        + e.getMessage()
      );
    } finally {
      this.clean();
    }
  }
  
  public Cliente getMayorGasto(Connection con) throws Exception {
    try {
      stmt = con.prepareStatement(
        "SELECT C.Nombre, C.Ape1, C.Ape2, "
          + "SUM(A.Precio * AF.Numero) AS TotalGasto "
          + "FROM Cliente C "
          + "JOIN Factura F ON C.DNI = F.Cliente_DNI "
          + "JOIN Articulo_Factura AF ON F.idFactura = AF.Factura_idFactura "
          + "JOIN Articulo A ON AF.Articulo_idArticulo = A.idArticulo "
          + "GROUP BY C.DNI "
          + "ORDER BY TotalGasto DESC "
          + "LIMIT 1;"
      );
      rs = stmt.executeQuery();
      rs.next();
      Cliente cli = new Cliente();
      cli.setNombre(rs.getString("Nombre"));
      cli.setApellido1(rs.getString("Ape1"));
      cli.setApellido2(rs.getString("Ape2"));
      cli.setSaldo(rs.getFloat("TotalGasto"));
      return cli;
    } catch (SQLException e) {
      Log.getInstance().error(e);
      throw new Exception(
        "Ha habido un problema al solicitar el mayor gasto "
        + e.getMessage()
      );
    } finally {
      this.clean();
    }
  }
  
  // Usado en:
  // - addArticuloFactura en BLL para añadir un producto a una factura
  public void insertArticuloFactura(
    Connection con, 
    int idFactura,
    int idArticulo, 
    int cantidadPedida
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
        "INSERT INTO articulo_factura "
        + "(numero, Articulo_idArticulo, Factura_idFactura)"
        + "VALUES (?,?,?)"
      );
      stmt.setInt(1, cantidadPedida);
      stmt.setInt(2, idArticulo);
      stmt.setInt(3, idFactura);
      stmt.executeUpdate();
    } catch (SQLException e) {
      Log.getInstance().error(e);
      throw new Exception(
        "Ha habido un problema al actualizar la cantidad pedida "
        + e.getMessage()
      );
    } finally {
      this.clean();
    }
  }
  
  // Usado en:
  // - addArticuloFactura en BLL para actualizar la cantidad pedida
  public int getCantidadPedidaByFCT(
    Connection con, int idFactura
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
        "SELECT numero FROM articulo_factura WHERE Factura_idFactura=?"
      );
      stmt.setInt(1, idFactura);
      rs = stmt.executeQuery();
      rs.next();
      return rs.getInt("numero");
    } catch (SQLException e) {
      Log.getInstance().error(e);
      throw new Exception(
        "Ha habido un problema al actualizar la cantidad pedida "
        + e.getMessage()
      );
    } finally {
      this.clean();
    }
  }
  
  // Usado en:
  // - addArticuloFactura en BLL para actualizar la cantidad pedida
  public void updateCantidadPedida(
    Connection con, 
    int idFactura,
    int idArticulo, 
    int cantidadPedida
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
        "UPDATE articulo_factura "
        + "SET numero=? "
        + "WHERE Articulo_idArticulo=? "
        + "AND Factura_idFactura=?"
      );
      stmt.setInt(1, cantidadPedida);
      stmt.setInt(2, idArticulo);
      stmt.setInt(3, idFactura);
      stmt.executeUpdate();
    } catch (SQLException e) {
      Log.getInstance().error(e);
      throw new Exception(
        "Ha habido un problema al actualizar la cantidad pedida "
        + e.getMessage()
      );
    } finally {
      this.clean();
    }
  }
  
  // Usado en:
  // - removeArticuloFactura BLL para eliminar una fila de factura
  public void deleteArticuloById(
    Connection con, 
    int idFactura,
    int idArticulo
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
        "DELETE FROM articulo_factura "
        + "WHERE Factura_idFactura=? AND Articulo_idArticulo=?"
      );
      stmt.setInt(1, idFactura);
      stmt.setInt(2, idArticulo);
      stmt.executeUpdate();
    } catch (SQLException e) {
      Log.getInstance().error(e);
      throw new Exception(
        "Ha habido un problema al borrar el articulo a la factura "
        + e.getMessage()
      );
    } finally {
      this.clean();
    }
  }
}
