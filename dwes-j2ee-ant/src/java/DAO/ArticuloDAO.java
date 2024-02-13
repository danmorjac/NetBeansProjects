/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Articulo;
import Entidad.Utilidad.Log;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticuloDAO extends AbstractDAO {

  private Articulo initArticulo() throws SQLException {
    return new Articulo(
            rs.getInt("idArticulo"),
            rs.getString("Descripcion"),
            rs.getFloat("Precio"),
            rs.getInt("Stock")
    );
  }

  public ArrayList<Articulo> findAll(Connection con) throws Exception {
    try {
      stmt = con.prepareStatement("SELECT * FROM Articulo");
      rs = stmt.executeQuery();

      ArrayList<Articulo> listaArticulos = new ArrayList();
      while (rs.next()) {
        listaArticulos.add(initArticulo());
      }
      return listaArticulos;
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
              "Ha habido un problema al buscar los articulos "
              + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public Articulo findById(
          Connection con,
          Articulo articulo
  ) throws Exception {
    int articuloId = articulo.getId();

    try {
      stmt = con.prepareStatement("SELECT * FROM articulo WHERE idArticulo=?");
      stmt.setInt(1, articuloId);
      rs = stmt.executeQuery();
      rs.next();

      return initArticulo();
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
              "Ha habido un problema al buscar el articulo con id "
              + articuloId
              + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public Articulo findById(
          Connection con,
          int idArticulo
  ) throws Exception {
    try {
      stmt = con.prepareStatement("SELECT * FROM articulo WHERE idArticulo=?");
      stmt.setInt(1, idArticulo);
      rs = stmt.executeQuery();
      rs.next();

      return initArticulo();
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
              "Ha habido un problema al buscar el articulo con id "
              + idArticulo
              + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public void updateElementById(
          Connection con,
          Articulo articulo,
          String element
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
              "UPDATE articulo SET " + element + "=? WHERE idArticulo=?"
      );

      switch (element) {
        case "Precio":
          stmt.setFloat(1, articulo.getPrecio());
          break;
        case "Stock":
          stmt.setInt(1, articulo.getStock());
          break;
        default:
          throw new Exception("Operacion no permitida");
      }
      stmt.setInt(2, articulo.getId());
      stmt.executeUpdate();
    } catch (SQLException ex) {
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

  public int getStock(Connection con, int artId) throws Exception {
    try {
      stmt = con.prepareStatement(
              "SELECT Stock FROM articulo WHERE idArticulo=?"
      );
      stmt.setInt(1, artId);
      rs = stmt.executeQuery();
      rs.next();
      return rs.getInt("Stock");
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
              "Ha habido un problema al obtener el stock del articulo con ID "
              + artId
              + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public void updateStock(
          Connection con, int artId, int stock
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
              "UPDATE articulo SET Stock=? WHERE idArticulo=?"
      );
      stmt.setInt(1, stock);
      stmt.setInt(2, artId);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
              "Ha habido un problema al actualizar el stock "
              + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public void deleteById(Connection con, int artId) throws Exception {
    try {
      stmt = con.prepareStatement("DELETE FROM articulo WHERE idArticulo=?");
      stmt.setInt(1, artId);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
              "Ha habido un problema al eliminar el articulo "
              + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public void insertArticulo(
          Connection con, String Descripcion, float Precio, int Stock
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
              "INSERT INTO Articulo (Descripcion, Precio, Stock) "
              + "VALUES (?,?,?);"
      );
      stmt.setString(1, Descripcion);
      stmt.setFloat(2, Precio);
      stmt.setInt(3, Stock);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
              "Ha habido un problema al insertar el articulo "
              + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }

  public void updateArticulo(
          Connection con, String Descripcion, float Precio, int Stock, int idArticulo
  ) throws Exception {
    try {
      stmt = con.prepareStatement(
              "UPDATE Articulo "
              + "SET Descripcion=?, "
              + "Precio=?, "
              + "Stock=? "
              + "WHERE idArticulo=?;"
      );
      stmt.setString(1, Descripcion);
      stmt.setFloat(2, Precio);
      stmt.setInt(3, Stock);
      stmt.setInt(4, idArticulo);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      Log.getInstance().error(ex);
      throw new Exception(
              "Ha habido un problema al actualizar el articulo "
              + ex.getMessage()
      );
    } finally {
      this.clean();
    }
  }
}
